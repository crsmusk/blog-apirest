package blog.blog.Service.Impl;

import blog.blog.Exception.Exceptions.PermisoNoEncontradoException;
import blog.blog.Mapper.PermisoMapper;
import blog.blog.Model.DTOs.PermisoDTO;
import blog.blog.Model.Entities.Permiso;
import blog.blog.Repository.PermisoRepository;
import blog.blog.Service.Interface.IPermiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PermisoServiceImpl implements IPermiso {

    @Autowired
    PermisoRepository permisoRepo;
    @Autowired
    PermisoMapper mapper;


    @Override
    public List<PermisoDTO> getAll() {
        List<Permiso>lista=permisoRepo.findAll();
        if (lista.isEmpty()){
            throw  new PermisoNoEncontradoException("no hay permisos registrados");
        }else{
            return mapper.permisosAPermisosDto(lista);
        }

    }

    @Override
    public PermisoDTO getById(Long id) {
        Optional<Permiso>permiso=permisoRepo.findById(id);
        if (permiso.isPresent()){
            return mapper.permisoAPermisoDto(permiso.get());
        }else{
            throw new PermisoNoEncontradoException("no se encotro el permiso con el id "+id);
        }
    }

    @Override
    public PermisoDTO getByNombre(String nombre) {
        Optional<Permiso>permiso=permisoRepo.findByNombrePermisoIgnoreCase(nombre);
        if (permiso.isPresent()){
            return mapper.permisoAPermisoDto(permiso.get());
        }else{
            throw new PermisoNoEncontradoException("no se encontro el permiso con el nombre "+nombre);
        }
    }

    @Override
    public void save(PermisoDTO permisoDTO) {
       Permiso permiso=new Permiso();
       permiso.setNombrePermiso(permisoDTO.getNombrePermiso());
       permisoRepo.save(permiso);
    }

    @Override
    public void delete(Long id) {
         if (permisoRepo.existsById(id)){
             permisoRepo.deleteById(id);
         }else{
             throw new PermisoNoEncontradoException("no se encontro el permiso con el id "+id);
         }
    }

    @Override
    public PermisoDTO update(Long id, PermisoDTO permisoDTO) {
        Optional<Permiso>permiso=permisoRepo.findById(id);
        if (permiso.isPresent()){
            permiso.get().setNombrePermiso(permisoDTO.getNombrePermiso());
            permisoRepo.save(permiso.get());
        }
        return null;
    }
}
