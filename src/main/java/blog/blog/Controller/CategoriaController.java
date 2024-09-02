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

import blog.blog.Model.DTOs.CategoriaDTO;
import blog.blog.Service.Impl.CategoriaServiceImpl;

@Controller
@RequestMapping("/Blog/Post/Categoria")
public class CategoriaController {
 
    @Autowired
    CategoriaServiceImpl categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>>GetAll(){
        if (categoriaService.GetAllCategoria().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(categoriaService.GetAllCategoria(),HttpStatus.OK);
        }
        
    }

    @GetMapping("/BuscarCategoriaPorNombre/{nombreCategoria}")
    public ResponseEntity<Optional<CategoriaDTO>>GetByNombre(@PathVariable String nombre){
        if(categoriaService.FindByNombre(nombre).isPresent()){
            return new ResponseEntity<>(categoriaService.FindByNombre(nombre),HttpStatus.OK);
        }else{
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/BuscarPorId/{id}")
    public ResponseEntity<Optional<CategoriaDTO>>GetById(@PathVariable Long id){
        if(categoriaService.FindById(id).isPresent()){
            return new ResponseEntity<>(categoriaService.FindById(id),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/CrearCategoria")
    public ResponseEntity<Optional<CategoriaDTO>>SaveCategoria(@RequestBody CategoriaDTO categoriaDt){
        return new ResponseEntity<>(categoriaService.Save(categoriaDt),HttpStatus.CREATED);
    }

    @PutMapping("/ActualizarCatgoria/{id}")
    public ResponseEntity<Optional<CategoriaDTO>>UdateCategoria(@PathVariable Long id,@RequestBody CategoriaDTO categoriaDt){
        if(categoriaService.Update(id, categoriaDt).isPresent()){
            return new ResponseEntity<>(categoriaService.Update(id, categoriaDt),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/BorrarCategoria/{id}")
    public ResponseEntity<?>DeleteById(@PathVariable Long id){
        categoriaService.DeleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
