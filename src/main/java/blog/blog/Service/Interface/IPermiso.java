package blog.blog.Service.Interface;

import blog.blog.Model.DTOs.PermisoDTO;

import java.util.List;

public interface IPermiso {
    public List<PermisoDTO> getAll();
    public PermisoDTO getById(Long id);
    public PermisoDTO getByNombre(String nombre);
    public void save(PermisoDTO permisoDTO);
    public void delete(Long id);
    public PermisoDTO update(Long id,PermisoDTO permisoDTO) ;
}
