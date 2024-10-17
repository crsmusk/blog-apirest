package blog.blog.Service.Impl;

import blog.blog.Exception.Exceptions.PermisoNoEncontradoException;
import blog.blog.Exception.Exceptions.RolNoEncontradoException;
import blog.blog.Mapper.RolMapper;
import blog.blog.Model.DTOs.RolDTO;
import blog.blog.Model.Entities.Permiso;
import blog.blog.Model.Entities.Rol;
import blog.blog.Repository.PermisoRepository;
import blog.blog.Repository.RolRepository;
import blog.blog.Service.Interface.IRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class RolServiceImpl implements IRol {

    @Autowired
    RolRepository rolRepo;
    @Autowired
    RolMapper mapper;
    @Autowired
    PermisoRepository permisoRepo;


    @Override
    public List<RolDTO> getAll() {
        List<Rol>lista=rolRepo.findAll();
        if (lista.isEmpty()){
            throw  new RolNoEncontradoException("no hay roles registrados");
        }else {
            return mapper.rolesARolesDto(lista);
        }
    }

    @Override
    public RolDTO getById(Long id) {
        Optional<Rol>rol=rolRepo.findById(id);
        if (rol.isPresent()){
            return mapper.rolARolDto(rol.get());
        }else {
            throw new RolNoEncontradoException("no se encontro al rol con el id "+id);
        }

    }

    @Override
    public RolDTO getByNombre(String nombre) {
        Optional<Rol>rol=rolRepo.findByNombreRolIgnoreCase(nombre);
        if (rol.isPresent()){
            return mapper.rolARolDto(rol.get());
        }else{
            throw new RolNoEncontradoException("no se encontro el rol con el nombre "+nombre);
        }
    }

    @Override
    @Transactional
    public void save(RolDTO rolDTO) {
       Rol rol=new Rol();
       rol.setNombreRol(rolDTO.getNombreRol());
       List<Permiso>permisos=new ArrayList<>();
       for (String i:rolDTO.getNombrePermisos()){
           if (permisoRepo.findByNombrePermisoIgnoreCase(i).isPresent()){
               permisos.add(permisoRepo.findByNombrePermisoIgnoreCase(i).get());
           }else {
               throw new PermisoNoEncontradoException("no se encontro el permiso con el nombre "+i);
           }
       }
       rol.setPermisos(permisos);
       rolRepo.save(rol);
    }

    @Override
    public void delete(Long id) {
       if (rolRepo.existsById(id)){
           rolRepo.deleteById(id);
       }else {
           throw new RolNoEncontradoException("no se encontro el rol con el id "+id);
       }
    }

    @Override
    public RolDTO changeNombreRol(Long id, String nombre) {
        Optional<Rol>rol=rolRepo.findById(id);
        if (rol.isPresent()){
            rol.get().setNombreRol(nombre);
            rolRepo.save(rol.get());
            return mapper.rolARolDto(rol.get());
        }else{
            throw new RolNoEncontradoException("no se encotro el rol con el nombre "+nombre);
        }
    }

    @Override
    @Transactional
    public RolDTO changePermisos(Long id,List<String> permisos) {
        Optional<Rol>rol=rolRepo.findById(id);
        if (rol.isPresent()){
            List<Permiso>lista=new ArrayList<>();
            for (String i:permisos){
                if (permisoRepo.findByNombrePermisoIgnoreCase(i).isPresent()){
                    lista.add(permisoRepo.findByNombrePermisoIgnoreCase(i).get());
                }else {
                    throw new PermisoNoEncontradoException("no se encontro el permiso con el nombre "+i);
                }
            }
            rol.get().setPermisos(lista);
            rolRepo.save(rol.get());
            return mapper.rolARolDto(rol.get());
        }else{
            throw new RolNoEncontradoException("no se encotro el rol con el id "+id);
        }

    }
}
