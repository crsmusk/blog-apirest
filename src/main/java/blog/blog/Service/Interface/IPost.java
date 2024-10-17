package blog.blog.Service.Interface;
import java.util.List;
import java.time.LocalDate;
import blog.blog.Model.DTOs.PostDTO;
import java.util.Optional;
public interface IPost {

   public List<PostDTO>getAllPosts();
   public List<PostDTO>findByPalabra(String palabra);
   public List<PostDTO>findByTitulo(String titulo);
   public List<PostDTO>findByDate(LocalDate fecha);
   public PostDTO findById(Long id);
   public PostDTO save(PostDTO postDt);
   public PostDTO update(Long id,PostDTO post);
   public void deleteById(Long id);

}
