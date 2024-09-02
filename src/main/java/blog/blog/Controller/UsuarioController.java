package blog.blog.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.blog.Model.DTOs.UsuarioDTO;
import blog.blog.Service.Impl.UsuarioServiceImpl;

@Controller
@RequestMapping("/Blog/Post/Usuario")
public class UsuarioController {
  
    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>>GetAll(){
        if (usuarioService.GetAllUsuarios().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(usuarioService.GetAllUsuarios(),HttpStatus.OK);
        }
    }

    @GetMapping("/BuscarUsuarioPorNickName/{NickName}")
    public ResponseEntity<Optional<UsuarioDTO>>GetByNickName(@PathVariable String NickName){
        if(usuarioService.FindByNickName(NickName).isPresent()){
            return new ResponseEntity<>(usuarioService.FindByNickName(NickName),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/BuscarUsuarioPorEmail/{Email}")
    public ResponseEntity<Optional<UsuarioDTO>>GetByEmail(@PathVariable String email){
        if (usuarioService.FindByEmail(email).isPresent()) {
            return new ResponseEntity<>(usuarioService.FindByEmail(email),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/GuardarUsuario")
    public ResponseEntity<Optional<UsuarioDTO>>SaveUsuario(@RequestBody UsuarioDTO usuarioDt){
        return new ResponseEntity<>(usuarioService.Save(usuarioDt),HttpStatus.OK);
    }

    @PutMapping("/ActualizarUsuario/{id}")
    public ResponseEntity<Optional<UsuarioDTO>>UpdateUsuario(@PathVariable Long id,@RequestBody UsuarioDTO usuarioDt){
      return new ResponseEntity<>(usuarioService.Update(id, usuarioDt),HttpStatus.OK);
    }

    @DeleteMapping("/BorrarUsuario/{id}")
    public ResponseEntity<?>DeleteById(@PathVariable Long id){
        usuarioService.DeleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
