package blog.blog.Service.Interface;
import java.util.List;
import java.util.Optional;

import blog.blog.Model.DTOs.CategoriaDTO;
public interface ICategoria {

  public List<CategoriaDTO>getAllCategoria();
  public CategoriaDTO findByNombre(String nombre);
  public CategoriaDTO findById(Long id);
  public CategoriaDTO save(CategoriaDTO CategoriaDt);
  public CategoriaDTO update(Long id,CategoriaDTO categoriaDt);
  public void deleteById(Long id);
}
