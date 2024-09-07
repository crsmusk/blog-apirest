package blog.blog.ServicioTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

import blog.blog.Exception.Exceptions.PostNoEncontradoException;
import blog.blog.Model.DTOs.PostDTO;
import blog.blog.Repository.PostRepository;
import blog.blog.Service.Impl.PostServiceImpl;

@SpringBootTest
public class PostServiceTest {
  PostDTO postEsperado=new PostDTO();
  Long idPost;

  @Autowired
  PostServiceImpl postService;
  @Autowired
  PostRepository postRepo;

  //se crea en base de datos un usuario,etiqueta y una categoria para facilitar la prueba
  @BeforeEach
  public void SetUp(){
    List<String> etiquetas = new ArrayList<>();
    List<String> comentarios = new ArrayList<>();
    etiquetas.add("videojuegos");
    postEsperado.setCategoria("tendencias");
    postEsperado.setContenido("se aproxima una proxima actualizacion de yugiho");
    postEsperado.setEtiquetas(etiquetas);
    postEsperado.setTitulo("novedades de yugiho");
    postEsperado.setNickNameCreador("troll45");
    postEsperado.setFechaPublicacion(LocalDate.of(2017, 10, 15));
    postEsperado.setComentarios(comentarios);
    postService.Save(postEsperado);
  }

  @Test 
  public void Post_Find_By_Titulo(){
    PostDTO postObtenido=postService.FindByTitulo(postEsperado.getTitulo()).get(0);

    assertEquals(postEsperado, postObtenido);
  }
  
  @Test
  public void Post_Find_By_Fecha(){
    PostDTO postObtenido=postService.FindByDate(LocalDate.of(2020, 10, 15)).get(0);
    
    assertEquals(postEsperado, postObtenido);
  }

  @Test 
  public void Post_Find_By_Id(){
    idPost=postRepo.findByTituloIgnoreCase(postEsperado.getTitulo()).get(0).getId();
    
    PostDTO postObtenido=postService.FindById(idPost).get();
    assertEquals(postEsperado,postObtenido );
  }

  @Test
  public void Post_Update(){
    idPost=postRepo.findByTituloIgnoreCase(postEsperado.getTitulo()).get(0).getId();
    postEsperado.setTitulo("yugiho");
    postService.Update(idPost, postEsperado);

    PostDTO postObtenido=postService.FindById(idPost).get();

    assertEquals(postEsperado, postObtenido);
  }

  @Test
  public void Post_Exception(){
    assertThrows(PostNoEncontradoException.class, ()->{
        postService.FindById(45L);
    });
  }


  @AfterEach
  public void Delete(){
    idPost=postRepo.findByTituloIgnoreCase(postEsperado.getTitulo()).get(0).getId();
    postService.DeleteById(idPost);
  }
}
