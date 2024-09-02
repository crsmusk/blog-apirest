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

import blog.blog.Model.DTOs.PostDTO;
import blog.blog.Service.Impl.PostServiceImpl;

@Controller
@RequestMapping("/Blog/Post")
public class PostController {
  
    @Autowired
    PostServiceImpl postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>>GetAll(){
        if (postService.GetAllPosts().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(postService.GetAllPosts(),HttpStatus.OK);
        }
    }

    @GetMapping("/BuscarPostPorId/{id}")
    public ResponseEntity<Optional<PostDTO>>GetById(@PathVariable Long id){
        if (postService.FindById(id).isPresent()) {
            return new ResponseEntity<>(postService.FindById(id),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/BuscarPostPorTitulo/{Titulo}")
    public ResponseEntity<List<PostDTO>>GetByTitulo(@PathVariable String titulo){
        if(postService.FindByTitulo(titulo).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(postService.FindByTitulo(titulo),HttpStatus.OK);
        }
    }

    @GetMapping("/BuscarPostPorContenido/{Contenido}")
    public ResponseEntity<List<PostDTO>>GetByContent(@PathVariable String contenido){
        if(postService.FindByPalabra(contenido).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(postService.FindByTitulo(contenido),HttpStatus.OK);
        }
    }

    @PostMapping("/GuardarPost")
    public ResponseEntity<Optional<PostDTO>>SavePost(@RequestBody PostDTO postDt){
        return new ResponseEntity<>(postService.Save(postDt),HttpStatus.OK);
    }

    @PutMapping("/ActualizarPost/{id}")
    public ResponseEntity<Optional<PostDTO>>UpdatePost(@PathVariable Long id,@RequestBody PostDTO postDt){
        return new ResponseEntity<>(postService.Update(id, postDt),HttpStatus.OK);
    }

    @DeleteMapping("/BorrarPost/{id}")
    public ResponseEntity<?>DeleteById(@PathVariable Long id){
        postService.DeleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
