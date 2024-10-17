package blog.blog.Mapper;

import blog.blog.Model.DTOs.PermisoDTO;
import blog.blog.Model.Entities.Permiso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermisoMapper {

    public PermisoDTO permisoAPermisoDto(Permiso permiso){
        PermisoDTO permisoDTO=PermisoDTO.builder()
                .nombrePermiso(permiso.getNombrePermiso())
                .id(permiso.getId())
                .build();
        return permisoDTO;
    }

    public List<PermisoDTO>permisosAPermisosDto(List<Permiso>permisos){
        return permisos.stream().map(this::permisoAPermisoDto).toList();
    }
}
