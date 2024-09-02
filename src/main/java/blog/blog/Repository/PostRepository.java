package blog.blog.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

import blog.blog.Model.Entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
  List<Post>findByFechaPublicacionLessThan(LocalDate fecha);
  List<Post>findByTituloIgnoreCase(String nombre);
  List<Post> findByCuerpoComentarioIgnoreCaseContaining(String palabra);
  
}
