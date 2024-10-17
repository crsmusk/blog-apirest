package blog.blog.Repository;

import blog.blog.Model.Entities.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso,Long> {
    Optional<Permiso> findByNombrePermisoIgnoreCase(String nombre);
}
