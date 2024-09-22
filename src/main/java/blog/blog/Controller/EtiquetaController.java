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
    public ResponseEntity<List<EtiquetaDTO>>GetAll(){
        if (etiquetaService.GetAllEtiquetas().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(etiquetaService.GetAllEtiquetas(),HttpStatus.OK);
        }
    }

    @GetMapping("/BuscarEtiquetasPorNombre/{NombreEtiqueta}")
    public ResponseEntity<Optional<EtiquetaDTO>>GetByNombre(@PathVariable String nombre){
        if (etiquetaService.findByNombreEtiqueta(nombre).isPresent()) {
            return new ResponseEntity<>(etiquetaService.findByNombreEtiqueta(nombre),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/BuscarPorId/{id}")
    public ResponseEntity<Optional<EtiquetaDTO>>GetById(@PathVariable Long id){
        if(etiquetaService.FindById(id).isPresent()){
            return new ResponseEntity<>(etiquetaService.FindById(id),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/GuardarEtiqueta")
    public ResponseEntity<Optional<EtiquetaDTO>>SaveEtiqueta(@RequestBody EtiquetaDTO etiquetaDt){
        return new ResponseEntity<>(etiquetaService.Save(etiquetaDt),HttpStatus.OK);
    }

    @PutMapping("/ActualizarEtiqueta/{id}")
    public ResponseEntity<Optional<EtiquetaDTO>>UpdateEtiqueta(@PathVariable Long id,@RequestBody EtiquetaDTO etiquetaDt){
        if (etiquetaService.Update(id, etiquetaDt).isPresent()) {
            return new ResponseEntity<>(etiquetaService.Update(id, etiquetaDt),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/BorrarEtiqueta/{id}")
    public ResponseEntity<?>DeleteById(@PathVariable Long id){
        etiquetaService.DeleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
