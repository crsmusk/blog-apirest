package blog.blog.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.blog.Exception.Exceptions.UsuarioNoEncontradoException;
import blog.blog.Mapper.UsuarioMapper;
import blog.blog.Model.DTOs.UsuarioDTO;
import blog.blog.Model.Entities.Usuario;
import blog.blog.Repository.UsuarioRepository;
import blog.blog.Service.Interface.IUsuario;
@Service
public class UsuarioServiceImpl implements IUsuario{


    @Autowired
    private UsuarioRepository usuarioRepo;
    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> GetAllUsuarios() {
        return usuarioMapper.toUsuariosDto(usuarioRepo.findAll());
    }

    @Override
    public Optional<UsuarioDTO> FindByEmail(String email) {
      if (usuarioRepo.findByEmailIgnoreCase(email).isPresent()) {
        return Optional.of(usuarioMapper.toUsuarioDto(usuarioRepo.findByEmailIgnoreCase(email).get()));
      }else{
        throw new UsuarioNoEncontradoException("no se econtro al usuario con el email "+email);
      }
    }

    @Override
    public Optional<UsuarioDTO> FindByNickName(String NickName) {
        if (usuarioRepo.findByNickNameIgnoreCase(NickName).isPresent()) {
            return Optional.of(usuarioMapper.toUsuarioDto(usuarioRepo.findByNickNameIgnoreCase(NickName).get()));
          }else{
            throw new UsuarioNoEncontradoException("no se econtro al usuario con el nickname "+NickName);
          }
    }

    @Override
    public Optional<UsuarioDTO> Save(UsuarioDTO usuarioDt) {
        Usuario usuario=new Usuario();
        usuario.setEmail(usuarioDt.getEmail());
        usuario.setPassword(usuarioDt.getPassword());
        usuario.setNickName(usuarioDt.getNickName());
        usuarioRepo.save(usuario);
        return Optional.of(usuarioMapper.toUsuarioDto(usuario));
    }

    @Override
    public Optional<UsuarioDTO> Update(Long id, UsuarioDTO usuarioDt) {
        if (usuarioRepo.findById(id).isPresent()) {
            Usuario usuario=usuarioRepo.findById(id).get();
            usuario.setEmail(usuarioDt.getEmail());
            usuario.setPassword(usuario.getPassword());
            usuario.setNickName(usuario.getNickName());
            usuarioRepo.save(usuario);
            return Optional.of(usuarioMapper.toUsuarioDto(usuario));
        }else{
            throw new UsuarioNoEncontradoException("no se encontro el usuario con el id "+id);
        }
    }

    @Override
    public void DeleteById(Long id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public Optional<UsuarioDTO> FindById(Long id) {
        if (usuarioRepo.findById(id).isPresent()) {
            return Optional.of(usuarioMapper.toUsuarioDto(usuarioRepo.findById(id).get()));
          }else{
            throw new UsuarioNoEncontradoException("no se econtro al usuario con el id "+id);
          }
    }

}
