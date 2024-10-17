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

import blog.blog.Model.DTOs.ComentarioDTO;
import blog.blog.Service.Impl.ComentarioServiceImpl;

@RestController
@RequestMapping("/Blog/Post/Comentarios")
public class ComentarioController {
  
    @Autowired
    ComentarioServiceImpl comentarioService;

    @GetMapping
    public List<ComentarioDTO>getAll(){
        return comentarioService.getAllComentarios();
    }

    @GetMapping("/BuscarComentarioPorId/{id}")
    public ResponseEntity<ComentarioDTO>getById(@PathVariable Long id){
            return new ResponseEntity<>(comentarioService.findById(id),HttpStatus.OK);
    }


    @GetMapping("/BuscarComentarioPorContenido/{postId}/{contenido}")
    public ResponseEntity<List<ComentarioDTO>>getByContent(@PathVariable Long postId,@PathVariable String contenido){
          return new ResponseEntity<>(comentarioService.findByContenido(postId, contenido),HttpStatus.OK);

    }

    @PostMapping("/GuardarComentario/{idPost}")
    public ResponseEntity<ComentarioDTO>saveComentario(@PathVariable Long idPost,@RequestBody ComentarioDTO comentarioDt){
        return new ResponseEntity<>(comentarioService.save(idPost, comentarioDt),HttpStatus.CREATED);
    }

    @PutMapping("/ActualizarComentario/{id}")
    public ResponseEntity<ComentarioDTO>updateComentario(@PathVariable Long id,@RequestBody ComentarioDTO comentarioDt){
            return new ResponseEntity<>(comentarioService.update(id, comentarioDt),HttpStatus.OK);
    }

    @DeleteMapping("/BorrarComentario")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        comentarioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
