package blog.blog.Service.UserDetails;

import blog.blog.Exception.Exceptions.UsuarioNoEncontradoException;
import blog.blog.Model.Entities.Permiso;
import blog.blog.Model.Entities.Rol;
import blog.blog.Model.Entities.Usuario;
import blog.blog.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userDetailService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario=usuarioRepo.findByEmailIgnoreCase(username).orElseThrow(()->new UsuarioNoEncontradoException("no se encontro al usuario con el email "+username));
        List<SimpleGrantedAuthority>lista=new ArrayList<>();
        usuario.getRoles().forEach(Rol->lista.add(new SimpleGrantedAuthority("ROLE_".concat(Rol.getNombreRol()))));

        usuario.getRoles().stream().flatMap(Rol->Rol.getPermisos().stream()).forEach(Permiso->lista.add(new SimpleGrantedAuthority(Permiso.getNombrePermiso())));
        return new User(usuario.getEmail(),
                usuario.getPassword(),
                usuario.getIsEnable(),
                usuario.getAccountNoExpired(),
                usuario.getAccountNoLocked(),usuario.getCredentialNoExpired(),lista);
    }
}
