package blog.blog.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import blog.blog.Exception.Exceptions.RolNoEncontradoException;
import blog.blog.Exception.Exceptions.noHayContenido;
import blog.blog.Model.Entities.Permiso;
import blog.blog.Model.Entities.Rol;
import blog.blog.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.blog.Exception.Exceptions.UsuarioNoEncontradoException;
import blog.blog.Mapper.UsuarioMapper;
import blog.blog.Model.DTOs.UsuarioDTO;
import blog.blog.Model.Entities.Usuario;
import blog.blog.Repository.UsuarioRepository;
import blog.blog.Service.Interface.IUsuario;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuario{


    @Autowired
    private UsuarioRepository usuarioRepo;
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario>lista=usuarioRepo.findAll();
        if (lista.isEmpty()){
            throw new noHayContenido();
        }else{
            return usuarioMapper.toUsuariosDto(usuarioRepo.findAll());
        }
    }

    @Override
    public UsuarioDTO findByEmail(String email) {
        Optional<Usuario>usuario=usuarioRepo.findByEmailIgnoreCase(email);
        if (usuario.isPresent()){
            return usuarioMapper.toUsuarioDto(usuario.get());
        }else{
            throw new UsuarioNoEncontradoException("no se entro el usuario con el email "+email);
        }
    }

    @Override
    public UsuarioDTO findByNickName(String nickName) {
        Optional<Usuario>usuario=usuarioRepo.findByNickNameIgnoreCase(nickName);
        if (usuario.isPresent()){
            return usuarioMapper.toUsuarioDto(usuario.get());
        }else{
            throw new UsuarioNoEncontradoException("no se encontro al usuario con el nickname "+nickName);
        }
    }

    @Override
    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDt) {
        Usuario usuario=new Usuario();
        usuario.setEmail(usuarioDt.getEmail());
        usuario.setPassword(usuarioDt.getPassword());
        usuario.setNickName(usuarioDt.getNickName());

        Optional<Rol>role=rolRepository.findByNombreRolIgnoreCase("CUSTOMER");
        if (role.isPresent()){

            usuario.setRoles(List.of(role.get()));
        }else {
            Rol rol=new Rol();
            rol.setNombreRol("CUSTOMER");
            rolRepository.save(rol);
            usuario.setRoles(List.of(rol));
        }
        usuarioRepo.save(usuario);
        return usuarioMapper.toUsuarioDto(usuario);
    }

    @Override
    public UsuarioDTO updateBasicData(Long id, UsuarioDTO usuarioDt) {
        if (usuarioRepo.findById(id).isPresent()) {
            Usuario usuario=usuarioRepo.findById(id).get();
            usuario.setEmail(usuarioDt.getEmail());
            usuario.setPassword(usuarioDt.getPassword());
            usuario.setNickName(usuarioDt.getNickName());
            usuarioRepo.save(usuario);
            return usuarioMapper.toUsuarioDto(usuario);
        }else{
            throw new UsuarioNoEncontradoException("no se encontro el usuario con el id "+id);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (usuarioRepo.existsById(id)){
            usuarioRepo.deleteById(id);
        }else{
            throw new UsuarioNoEncontradoException("no se econtro el usuario con el id "+id);
        }
    }

    @Override
    @Transactional
    public UsuarioDTO updateRol(Long id,List<String> roles) {
        Optional<Usuario>usuario=usuarioRepo.findById(id);
        if (usuario.isPresent()){
            List<Rol>lista=new ArrayList<>();
            for (String i:roles){
                if (rolRepository.findByNombreRolIgnoreCase(i).isPresent()){
                    lista.add(rolRepository.findByNombreRolIgnoreCase(i).get());
                }else {
                    throw new RolNoEncontradoException("no se encontro el rol con el nombre "+i);
                }
            }
            return usuarioMapper.toUsuarioDto(usuario.get());
        }else{
            throw new UsuarioNoEncontradoException("no se encotro el usuario con el id "+id);
        }

    }

    @Override
    public UsuarioDTO findById(Long id) {
        Optional<Usuario>usuario=usuarioRepo.findById(id);
        if (usuario.isPresent()){
            return usuarioMapper.toUsuarioDto(usuario.get());
        }else{
            throw new UsuarioNoEncontradoException("no se econtro el usuario con el id "+id);
        }
    }

}
