package blog.blog.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

import blog.blog.Model.Entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
  List<Post>findByFechaPublicacionLessThan(LocalDate fecha);
  
  List<Post>findByTituloIgnoreCase(String nombre);

  @Query("SELECT p FROM Post p JOIN p.comentarios c WHERE LOWER(c.cuerpoComentario) LIKE LOWER(CONCAT('%', :palabra, '%'))")
  List<Post> findByCuerpoComentarioIgnoreCaseContaining(@Param("palabra") String palabra);
  
}
