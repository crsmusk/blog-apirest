package blog.blog.ServicioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import blog.blog.Exception.Exceptions.UsuarioNoEncontradoException;
import blog.blog.Model.DTOs.UsuarioDTO;
import blog.blog.Repository.UsuarioRepository;
import blog.blog.Service.Impl.UsuarioServiceImpl;

/*@SpringBootTest
public class UsuarioServiceTest {
 
    UsuarioDTO usuarioEsperado=new UsuarioDTO();
    Long idUsuario;

    @Autowired
    UsuarioServiceImpl usuarioService;
    @Autowired
    UsuarioRepository usuarioRepo;

    @BeforeEach
    public void SetUp(){
        usuarioEsperado.setEmail("jose@Gmail.com");
        usuarioEsperado.setNickName("abusamadres123");
        usuarioEsperado.setPassword("Apple1234*");
        usuarioService.save(usuarioEsperado);
    }

    @Test
    public void Usuario_Find_By_Email(){
     UsuarioDTO usuarioObtenido=usuarioService.findByEmail(usuarioEsperado.getEmail());
     assertEquals(usuarioEsperado, usuarioObtenido);
    }

    @Test
    public void Usuario_Find_By_NickName(){
        UsuarioDTO usuarioOptenido=usuarioService.findByNickName(usuarioEsperado.getNickName());


        assertEquals(usuarioEsperado, usuarioOptenido);
    }

    @Test
    public void Usuario_Find_By_Id(){
        idUsuario=usuarioRepo.findByEmailIgnoreCase(usuarioEsperado.getEmail()).get().getId();
        UsuarioDTO usuarioOptenido=usuarioService.findById(idUsuario);


        assertEquals(usuarioEsperado, usuarioOptenido);
    }

    @Test
    public void Usuario_Update(){
        idUsuario=usuarioRepo.findByEmailIgnoreCase(usuarioEsperado.getEmail()).get().getId();
        usuarioEsperado.setNickName("almizcle");
        usuarioService.updateBasicData(idUsuario, usuarioEsperado);

        UsuarioDTO usuarioOptenido=usuarioService.findById(idUsuario);

        assertEquals(usuarioEsperado, usuarioOptenido);
    }

    @Test
    public void Usuario_Exception(){
        assertThrows(UsuarioNoEncontradoException.class, ()->{
            usuarioService.findById(56L);
        });
    }

    @AfterEach
    public void Delete(){
        idUsuario=usuarioRepo.findByEmailIgnoreCase(usuarioEsperado.getEmail()).get().getId();
        usuarioService.deleteById(idUsuario);
    }
}*/
