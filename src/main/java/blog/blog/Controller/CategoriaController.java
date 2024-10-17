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

import blog.blog.Model.DTOs.CategoriaDTO;
import blog.blog.Service.Impl.CategoriaServiceImpl;

@RestController
@RequestMapping("/Blog/Post/Categoria")
public class CategoriaController {
 
    @Autowired
    CategoriaServiceImpl categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>>getAll(){
            return new ResponseEntity<>(categoriaService.getAllCategoria(),HttpStatus.OK);
    }

    @GetMapping("/BuscarCategoriaPorNombre/{nombre}")
    public ResponseEntity<CategoriaDTO>getByNombre(@PathVariable String nombre){
            return new ResponseEntity<>(categoriaService.findByNombre(nombre),HttpStatus.OK);
    }

    @GetMapping("/BuscarPorId/{id}")
    public ResponseEntity<CategoriaDTO>getById(@PathVariable Long id){
            return new ResponseEntity<>(categoriaService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO>saveCategoria(@RequestBody CategoriaDTO categoriaDt){
        return new ResponseEntity<>(categoriaService.save(categoriaDt),HttpStatus.CREATED);
    }

    @PutMapping("/ActualizarCatgoria/{id}")
    public ResponseEntity<CategoriaDTO>updateCategoria(@PathVariable Long id,@RequestBody CategoriaDTO categoriaDt){
            return new ResponseEntity<>(categoriaService.update(id, categoriaDt),HttpStatus.OK);
    }

    @DeleteMapping("/BorrarCategoria/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
        categoriaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
