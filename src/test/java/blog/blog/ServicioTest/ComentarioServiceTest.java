package blog.blog.ServicioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import blog.blog.Exception.Exceptions.ComentarioNoEncontradoException;
import blog.blog.Model.DTOs.ComentarioDTO;
import blog.blog.Repository.ComentarioRepository;
import blog.blog.Service.Impl.ComentarioServiceImpl;

/*@SpringBootTest
public class ComentarioServiceTest {

  ComentarioDTO comentarioEsperado=new ComentarioDTO();
  long idComentario;

  @Autowired
  ComentarioServiceImpl comentarioService;
  @Autowired
  ComentarioRepository comentarioRepo;

  //se crea un post en base de datos para la prueva
  @BeforeEach
  public void SetUP(){
    comentarioEsperado.setCuerpoComentario("nombre de la cancion XD");
    comentarioService.Save(1L, comentarioEsperado);
  }

  @Test
  public void Comentario_Find_By_CuerpoComentario(){
    ComentarioDTO comentarioOptenido=comentarioService.findByContenidos(comentarioEsperado.getCuerpoComentario()).get().get(0);
    assertEquals(comentarioEsperado, comentarioOptenido);
  }

  @Test
  public void Comentario_Find_By_CuerpoComentario_And_idPost(){
    ComentarioDTO comentarioOptenido=comentarioService.findByContenido(1L, comentarioEsperado.getCuerpoComentario()).get().get(0);
    assertEquals(comentarioEsperado.getCuerpoComentario(), comentarioOptenido.getCuerpoComentario());
  }

  @Test
  public void Comentario_Find_By_Id(){
    idComentario=comentarioRepo.findByCuerpoComentarioIgnoreCaseContaining(comentarioEsperado.getCuerpoComentario()).get(0).getId();
    ComentarioDTO comentarioObtenido=comentarioService.FindById(idComentario).get();
    assertEquals(comentarioEsperado, comentarioObtenido);
  }

  @Test
  public void Comentario_Update(){
    idComentario=comentarioRepo.findByCuerpoComentarioIgnoreCaseContaining(comentarioEsperado.getCuerpoComentario()).get(0).getId();
     comentarioEsperado.setCuerpoComentario("C:");
     comentarioService.Update(idComentario, comentarioEsperado);

     ComentarioDTO comentarioOptenido=comentarioService.FindById(idComentario).get();
     assertEquals(comentarioEsperado, comentarioOptenido);
  }

  @Test
  public void Comentario_Exception(){
    assertThrows(ComentarioNoEncontradoException.class, ()->{
        comentarioService.FindById(34L);
    });
  }

  @AfterEach
  public void Delete(){
    idComentario=comentarioRepo.findByCuerpoComentarioIgnoreCaseContaining(comentarioEsperado.getCuerpoComentario()).get(0).getId();
    comentarioRepo.deleteById(idComentario);
  }
}*/
