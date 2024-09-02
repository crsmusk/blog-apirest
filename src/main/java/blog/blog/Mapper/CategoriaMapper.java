package blog.blog.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import blog.blog.Model.DTOs.CategoriaDTO;
import blog.blog.Model.Entities.Categoria;

@Component
public class CategoriaMapper {

  public CategoriaDTO toCategoriaDto(Categoria categoria){
    return CategoriaDTO.builder()
    .NombreCategoria(categoria.getNombreCategoria())
    .build();
   }

  public List<CategoriaDTO>toCategoriasDTO(List<Categoria> categorias){
    return categorias.stream().map(this::toCategoriaDto).toList();
  }
}
