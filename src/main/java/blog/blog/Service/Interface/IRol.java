package blog.blog.Service.Interface;

import blog.blog.Model.DTOs.RolDTO;
import blog.blog.Model.Entities.Rol;

import java.util.List;

public interface IRol {
    public List<RolDTO>getAll();
    public RolDTO getById(Long id);
    public RolDTO getByNombre(String nombre);
    public void save(RolDTO rolDTO);
    public void delete(Long id);
    public RolDTO changeNombreRol(Long id,String nombre);
    public RolDTO changePermisos(Long id,List<String>permisos);
}
