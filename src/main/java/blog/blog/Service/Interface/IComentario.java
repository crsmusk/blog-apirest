package blog.blog.Service.Interface;
import java.util.List;
import java.util.Optional;

import blog.blog.Model.DTOs.ComentarioDTO;
public interface IComentario {

  public List<ComentarioDTO>getAllComentarios();
  public ComentarioDTO findById(Long id);
  public List<ComentarioDTO> findByContenidos(String contenido);
  public  List<ComentarioDTO> findByContenido(Long idPost,String contenido);
  public ComentarioDTO save(Long idPost,ComentarioDTO comentario);
  public  ComentarioDTO  update (Long id,ComentarioDTO comentari);
  public void deleteById(Long id);
  
}
