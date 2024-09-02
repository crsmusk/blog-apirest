package blog.blog.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.blog.Model.Entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
  Optional<Categoria>findByNombreCategoria(String Nombre);
}
