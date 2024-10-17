package blog.blog.Mapper;

import blog.blog.Model.DTOs.RolDTO;
import blog.blog.Model.Entities.Permiso;
import blog.blog.Model.Entities.Rol;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolMapper {

    public RolDTO rolARolDto(Rol rol){
        RolDTO rolDto=RolDTO.builder()
                .nombreRol(rol.getNombreRol())
                .id(rol.getId())
                .nombrePermisos(rol.getPermisos().stream().map(Permiso::getNombrePermiso).toList())
                .build();
        return rolDto;
    }

    public List<RolDTO>rolesARolesDto(List<Rol>roles){
        return roles.stream().map(this::rolARolDto).toList();
    }
}
