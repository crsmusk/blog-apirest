package blog.blog.ServicioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import blog.blog.Exception.Exceptions.EtiquetaNoEncontradaException;
import blog.blog.Model.DTOs.EtiquetaDTO;
import blog.blog.Repository.EtiquetaRepository;
import blog.blog.Service.Impl.EtiquetaServiceImpl;

@SpringBootTest
public class EtiquetaServiceTest {
  
    EtiquetaDTO etiquetaEsperada=new EtiquetaDTO();
    Long idEtiqueta;

    @Autowired
    EtiquetaServiceImpl etiquetaService;
    @Autowired
    EtiquetaRepository etiquetaRepo;

    @BeforeEach
    public void SetUp(){
        etiquetaEsperada.setNombreEtiqueta("musica");
        etiquetaService.Save(etiquetaEsperada);
    }

    @Test
    public void Etiqueta_Find_By_Id(){
        idEtiqueta=etiquetaRepo.findByNombreEtiquetaIgnoreCase(etiquetaEsperada.getNombreEtiqueta()).get().getId();
        EtiquetaDTO etiquetaObtenida=etiquetaService.FindById(idEtiqueta).get();
        assertEquals(etiquetaEsperada, etiquetaObtenida);

    }

    @Test
    public void Etiqueta_Find_By_NombreEtiqueta(){
        EtiquetaDTO etiquetaObtenida=etiquetaService.findByNombreEtiqueta(etiquetaEsperada.getNombreEtiqueta()).get();
        assertEquals(etiquetaEsperada, etiquetaObtenida);
    }

    @Test
    public void Etiqueta_Update(){
        idEtiqueta=etiquetaRepo.findByNombreEtiquetaIgnoreCase(etiquetaEsperada.getNombreEtiqueta()).get().getId();
        etiquetaEsperada.setNombreEtiqueta("pop");
        etiquetaService.Update(idEtiqueta, etiquetaEsperada);

        EtiquetaDTO etiquetaObtenida=etiquetaService.FindById(idEtiqueta).get();
        assertEquals(etiquetaEsperada, etiquetaObtenida);
    }

    @Test
    public void Etiqueta_Exception(){
        assertThrows(EtiquetaNoEncontradaException.class, ()->{
            etiquetaService.FindById(45L);
        });
    }

    @AfterEach
    public void Delete(){
        idEtiqueta=etiquetaRepo.findByNombreEtiquetaIgnoreCase(etiquetaEsperada.getNombreEtiqueta()).get().getId();
        etiquetaService.DeleteById(idEtiqueta);
    }
}
