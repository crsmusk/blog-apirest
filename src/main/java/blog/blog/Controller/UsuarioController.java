package blog.blog.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.blog.Model.DTOs.UsuarioDTO;
import blog.blog.Service.Impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/Blog/Usuario")
public class UsuarioController {
  
    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>>getAll(){
            return new ResponseEntity<>(usuarioService.getAllUsuarios(),HttpStatus.OK);
    }

    @GetMapping("/BuscarUsuarioPorNickName/{nickName}")
    public ResponseEntity<UsuarioDTO>getByNickName(@PathVariable String nickName){
            return new ResponseEntity<>(usuarioService.findByNickName(nickName),HttpStatus.OK);
    }

    @GetMapping("/BuscarUsuarioPorEmail/{email}")
    public ResponseEntity<UsuarioDTO>getByEmail(@PathVariable String email){
            return new ResponseEntity<>(usuarioService.findByEmail(email),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO>saveUsuario(@RequestBody UsuarioDTO usuarioDt){
        return new ResponseEntity<>(usuarioService.save(usuarioDt),HttpStatus.CREATED);
    }

    @PutMapping("/ActualizarDatosDelUsuario/{id}")
    public ResponseEntity<UsuarioDTO>updateUsuario(@PathVariable Long id,@RequestBody UsuarioDTO usuarioDt){
      return new ResponseEntity<>(usuarioService.updateBasicData(id, usuarioDt),HttpStatus.OK);
    }

    @PutMapping("/cambiarRoles/{id}")
    public ResponseEntity<UsuarioDTO>updateRolesUsuario(@PathVariable Long id,@RequestBody List<String>roles){
        return new ResponseEntity<>(usuarioService.updateRol(id,roles),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
        usuarioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
