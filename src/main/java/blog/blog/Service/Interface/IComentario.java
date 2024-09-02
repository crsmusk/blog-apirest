package blog.blog.Service.Interface;
import java.util.List;
import java.util.Optional;

import blog.blog.Model.DTOs.ComentarioDTO;
public interface IComentario {

  public List<ComentarioDTO>GetAllComentarios();
  public Optional<ComentarioDTO>FindById(Long id);
  public Optional<List<ComentarioDTO>>findByContenidos(String contenido);
  public Optional<List<ComentarioDTO>>findByContenido(Long idPost,String contenido);
  public Optional<ComentarioDTO> Save(Long idPost,ComentarioDTO comentario);
  public Optional<ComentarioDTO>  Update (Long id,ComentarioDTO comentari);
  public void DeleteById(Long id);
  
}
