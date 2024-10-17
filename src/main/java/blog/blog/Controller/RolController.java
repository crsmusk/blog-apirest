package blog.blog.Controller;

import blog.blog.Model.DTOs.RolDTO;

import blog.blog.Service.Impl.RolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/usuario/roles")
public class RolController {

    @Autowired
    RolServiceImpl rolService;

    @GetMapping
    public ResponseEntity<List<RolDTO>>getAll(){
        return new ResponseEntity<>(rolService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/buscarRolPorId/{id}")
    public ResponseEntity<RolDTO>getById(@PathVariable Long id){
        return new ResponseEntity<>(rolService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/buscarRolPorNombre/{nombre}")
    public ResponseEntity<RolDTO>getByNombre(@PathVariable String nombre){
        return new ResponseEntity<>(rolService.getByNombre(nombre),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?>save(@RequestBody RolDTO rolDTO){
        rolService.save(rolDTO);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/actualizarNombre/{id}/{nombre}")
    public ResponseEntity<RolDTO>updateBasicData(@PathVariable Long id,@PathVariable String nombre){
        return new ResponseEntity<>(rolService.changeNombreRol(id,nombre),HttpStatus.OK);
    }
    @PutMapping("/actualizarPermisos/{id}")
    public ResponseEntity<RolDTO>changePermission(@PathVariable Long id,@RequestBody List<String>permisos){
        return new ResponseEntity<>(rolService.changePermisos(id,permisos),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
