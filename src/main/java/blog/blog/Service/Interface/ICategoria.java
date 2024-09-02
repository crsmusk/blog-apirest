package blog.blog.Service.Interface;
import java.util.List;
import java.util.Optional;

import blog.blog.Model.DTOs.CategoriaDTO;
public interface ICategoria {

  public List<CategoriaDTO>GetAllCategoria();
  public Optional<CategoriaDTO>FindByNombre(String nombre);
  public Optional<CategoriaDTO>FindById(Long id);
  public Optional<CategoriaDTO> Save(CategoriaDTO CategoriaDt);
  public Optional<CategoriaDTO> Update(Long id,CategoriaDTO categoriaDt);
  public void DeleteById(Long id);
}
