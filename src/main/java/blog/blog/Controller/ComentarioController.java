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
    public List<ComentarioDTO>GetAll(){
        return comentarioService.GetAllComentarios();
    }

    @GetMapping("/BuscarComentarioPorId/{id}")
    public ResponseEntity<Optional<ComentarioDTO>>GetById(@PathVariable Long id){

        if (comentarioService.FindById(id).isPresent()) {

            return new ResponseEntity<>(comentarioService.FindById(id),HttpStatus.OK);

        }else{

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/BuscarComentarioPorContenido/{PosId}/{Contenido}")
    public ResponseEntity<Optional<List<ComentarioDTO>>>GetByContent(@PathVariable Long idPost,@PathVariable String contenido){

        if(comentarioService.findByContenido(idPost,contenido).isPresent()){

          return new ResponseEntity<>(comentarioService.findByContenido(idPost, contenido),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/GuardarComentario/{idPost}")
    public ResponseEntity<Optional<ComentarioDTO>>SaveComentario(@PathVariable Long idPost,@RequestBody ComentarioDTO comentarioDt){

        return new ResponseEntity<>(comentarioService.Save(idPost, comentarioDt),HttpStatus.OK);

    }

    @PutMapping("/ActualizarComentario/{id}")
    public ResponseEntity<Optional<ComentarioDTO>>UpdateComentario(@PathVariable Long id,@RequestBody ComentarioDTO comentarioDt){
        if (comentarioService.Update(id, comentarioDt).isPresent()) {
            return new ResponseEntity<>(comentarioService.Update(id, comentarioDt),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/BorrarComentario")
    public ResponseEntity<?> DeleteById(@PathVariable Long id){
        comentarioService.DeleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
