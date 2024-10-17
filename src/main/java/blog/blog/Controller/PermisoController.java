package blog.blog.Controller;

import blog.blog.Model.DTOs.PermisoDTO;
import blog.blog.Service.Impl.PermisoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/usuario/permiso")
public class PermisoController {

    @Autowired
    PermisoServiceImpl permisoService;

    @GetMapping
    public ResponseEntity<List<PermisoDTO>>getAll(){
        return new ResponseEntity<>(permisoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<PermisoDTO>getById(@PathVariable Long id){
        return new ResponseEntity<>(permisoService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/buscarPorNombre/{nombre}")
    public ResponseEntity<PermisoDTO>getByNombre(@PathVariable String nombre){
        return new ResponseEntity<>(permisoService.getByNombre(nombre),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody PermisoDTO permisoDTO){
        permisoService.save(permisoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermisoDTO>updatePermiso(@PathVariable Long id,@RequestBody PermisoDTO permisoDTO){
        return new ResponseEntity<>(permisoService.update(id,permisoDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        permisoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
