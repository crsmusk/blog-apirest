package blog.blog.Service.Interface;
import java.util.List;
import java.time.LocalDate;
import blog.blog.Model.DTOs.PostDTO;
import java.util.Optional;
public interface IPost {

   public List<PostDTO>GetAllPosts();
   public List<PostDTO>FindByPalabra(String palabra);
   public List<PostDTO>FindByTitulo(String titulo);
   public List<PostDTO>FindByDate(LocalDate fecha);
   public Optional<PostDTO>FindById(Long id);
   public Optional<PostDTO> Save(PostDTO postDt);
   public Optional<PostDTO> Update(Long id,PostDTO post);
   public void DeleteById(Long id);

}
