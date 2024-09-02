package blog.blog.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import blog.blog.Model.Entities.Etiqueta;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta,Long>{
  Optional<Etiqueta>findByNombreEtiquetaIgnoreCase(String nombre);
  List<Etiqueta>findByNombreEtiquetaInIgnoreCase(List<String>nombres);
}
