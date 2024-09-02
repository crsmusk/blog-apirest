package blog.blog.Repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import blog.blog.Model.Entities.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long>{

 List<Comentario> findByCuerpoComentarioIgnoreCaseContaining(String palabra);

  @Query("SELECT c FROM Comentario c JOIN Post p WHERE p.id = :id AND c.cuerpoComentario LIKE %:palabra%")
  List<Comentario> findByCuerpoComentario(@Param("palabra") String palabra, @Param("id") Long id);

  
}