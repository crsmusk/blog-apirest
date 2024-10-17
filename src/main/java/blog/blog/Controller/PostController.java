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

import blog.blog.Model.DTOs.PostDTO;
import blog.blog.Service.Impl.PostServiceImpl;

@RestController
@RequestMapping("/Blog/Post")
public class PostController {
  
    @Autowired
    PostServiceImpl postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>>getAll(){
            return new ResponseEntity<>(postService.getAllPosts(),HttpStatus.OK);
    }

    @GetMapping("/BuscarPostPorId/{id}")
    public ResponseEntity<PostDTO>getById(@PathVariable Long id){
            return new ResponseEntity<>(postService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/BuscarPostPorTitulo/{titulo}")
    public ResponseEntity<List<PostDTO>>getByTitulo(@PathVariable String titulo){
            return new ResponseEntity<>(postService.findByTitulo(titulo),HttpStatus.OK);
    }

    @GetMapping("/BuscarPostPorContenido/{contenido}")
    public ResponseEntity<List<PostDTO>>getByContent(@PathVariable String contenido){
            return new ResponseEntity<>(postService.findByTitulo(contenido),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDTO>savePost(@RequestBody PostDTO postDt){
        return new ResponseEntity<>(postService.save(postDt),HttpStatus.CREATED);
    }

    @PutMapping("/ActualizarPost/{id}")
    public ResponseEntity<PostDTO>updatePost(@PathVariable Long id,@RequestBody PostDTO postDt){
        return new ResponseEntity<>(postService.update(id, postDt),HttpStatus.OK);
    }

    @DeleteMapping("/BorrarPost/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
        postService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
