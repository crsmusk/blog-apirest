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

import blog.blog.Model.DTOs.EtiquetaDTO;
import blog.blog.Service.Impl.EtiquetaServiceImpl;

@RestController
@RequestMapping("/Blog/Post/Etiqueta")
public class EtiquetaController {
 
    @Autowired
    EtiquetaServiceImpl etiquetaService;

    @GetMapping
    public ResponseEntity<List<EtiquetaDTO>>getAll(){
        return new ResponseEntity<>(etiquetaService.getAllEtiquetas(),HttpStatus.OK);
    }

    @GetMapping("/BuscarEtiquetasPorNombre/{nombre}")
    public ResponseEntity<EtiquetaDTO>getByNombre(@PathVariable String nombre){
        return new ResponseEntity<>(etiquetaService.findByNombreEtiqueta(nombre),HttpStatus.OK);
    }

    @GetMapping("/BuscarPorId/{id}")
    public ResponseEntity<EtiquetaDTO>getById(@PathVariable Long id){
            return new ResponseEntity<>(etiquetaService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EtiquetaDTO>saveEtiqueta(@RequestBody EtiquetaDTO etiquetaDt){
        return new ResponseEntity<>(etiquetaService.save(etiquetaDt),HttpStatus.CREATED);
    }

    @PutMapping("/ActualizarEtiqueta/{id}")
    public ResponseEntity<EtiquetaDTO>updateEtiqueta(@PathVariable Long id,@RequestBody EtiquetaDTO etiquetaDt){
            return new ResponseEntity<>(etiquetaService.update(id, etiquetaDt),HttpStatus.OK);
    }

    @DeleteMapping("/BorrarEtiqueta/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
        etiquetaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
