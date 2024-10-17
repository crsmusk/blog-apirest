package blog.blog.Exception.ExceptionHandler;

import blog.blog.Exception.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import blog.blog.Exception.Error;

@ControllerAdvice
public class GlobalExceptionHandler {
  
    @ExceptionHandler(CategoriaNoEncontradaException.class)
    public ResponseEntity<Error>ManejarCategoriaNoEncontradaException(CategoriaNoEncontradaException ex){
        Error error=new Error(
            HttpStatus.NOT_FOUND.value()
            ,ex.getMessage()
            ,System.currentTimeMillis());
            return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ComentarioNoEncontradoException.class)
    public ResponseEntity<Error>ManejarComentarioNoEncontradoException(ComentarioNoEncontradoException ex){
        Error error=new Error(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EtiquetaNoEncontradaException.class)
    public ResponseEntity<Error>ManejarEtiquetaNoEncontradaException(EtiquetaNoEncontradaException ex){
        Error error=new Error( 
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNoEncontradoException.class)
    public ResponseEntity<Error>ManejarPostNoEncontradoException(PostNoEncontradoException ex){
        Error error=new Error( 
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<Error>ManejarUsuarioNoEncontradoException(UsuarioNoEncontradoException ex){
        Error error=new Error(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PermisoNoEncontradoException.class)
    public ResponseEntity<Error>manejarPermisoNoEncontradoException(PermisoNoEncontradoException ex){
        Error error=new Error(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(noHayContenido.class)
    public ResponseEntity<Error>manejarNoHayContenido(noHayContenido ex){
        Error error=new Error(
                HttpStatus.NO_CONTENT.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.NO_CONTENT);
    }
}
