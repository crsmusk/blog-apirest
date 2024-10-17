package blog.blog.ServicioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import blog.blog.Exception.Exceptions.CategoriaNoEncontradaException;
import blog.blog.Model.DTOs.CategoriaDTO;
import blog.blog.Repository.CategoriaRepository;
import blog.blog.Service.Impl.CategoriaServiceImpl;

/*@SpringBootTest
public class CategoriaServiceTest {
    
    CategoriaDTO categoriaDtEsperada=new CategoriaDTO();
    Long idCategoria;
    
    @Autowired
    CategoriaServiceImpl categoriaService;
    @Autowired
    CategoriaRepository categoriaRepo;

    @BeforeEach
    public void SetUP(){
        categoriaDtEsperada.setNombreCategoria("Anime");
        categoriaService.save(categoriaDtEsperada);
    }

    @Test
    public void Categoria_Find_By_NombreCategoria(){
        
        CategoriaDTO categoriaOptenida=categoriaService.findByNombre(categoriaDtEsperada.getNombreCategoria()).get();
        assertEquals(categoriaDtEsperada, categoriaOptenida);
    }
    
    @Test
    public void Categoria_Find_By_Id(){
        idCategoria=categoriaRepo.findByNombreCategoria(categoriaDtEsperada.getNombreCategoria()).get().getId();
        CategoriaDTO categoriaOptenida=categoriaService.findById(idCategoria).get();
        assertEquals(categoriaDtEsperada, categoriaOptenida);
    }

    @Test
    public void Categoria_Update(){
     idCategoria=categoriaRepo.findByNombreCategoria(categoriaDtEsperada.getNombreCategoria()).get().getId();
     categoriaDtEsperada.setNombreCategoria("Nacional");
     categoriaService.update(idCategoria, categoriaDtEsperada);
     CategoriaDTO categoriaObtenida=categoriaService.findById(idCategoria).get();

     assertEquals(categoriaDtEsperada.getNombreCategoria(), categoriaObtenida.getNombreCategoria());

    }

    @Test
    public void Categoria_Exception(){
        assertThrows(CategoriaNoEncontradaException.class, ()->{
            categoriaService.findById(45L);
        });
    }

    @AfterEach
    public void Delete(){
        idCategoria=categoriaRepo.findByNombreCategoria(categoriaDtEsperada.getNombreCategoria()).get().getId();
        categoriaRepo.deleteById(idCategoria);
    }

}
*/