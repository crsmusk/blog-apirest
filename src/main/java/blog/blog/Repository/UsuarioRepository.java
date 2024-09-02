package blog.blog.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.blog.Model.Entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Long>{
 Optional<Usuario>findByEmailIgnoreCase(String email);
 Optional<Usuario>findByNickNameIgnoreCase(String nick);
}
