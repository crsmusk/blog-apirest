package blog.blog.Exception.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import blog.blog.Exception.Error;
import blog.blog.Exception.Exceptions.CategoriaNoEncontradaException;
import blog.blog.Exception.Exceptions.ComentarioNoEncontradoException;
import blog.blog.Exception.Exceptions.EtiquetaNoEncontradaException;
import blog.blog.Exception.Exceptions.PostNoEncontradoException;
import blog.blog.Exception.Exceptions.UsuarioNoEncontradoException;

@ControllerAdvice
public class GlobalExceptionHandler {
  
    @ExceptionHandler(CategoriaNoEncontradaException.class)
    public ResponseEntity<Error>ManejarCategoriaNoEncontradaException(CategoriaNoEncontradaException ex){
        Error error=new Error(
            HttpStatus.BAD_REQUEST.value()
            ,ex.getMessage()
            ,System.currentTimeMillis());
            return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ComentarioNoEncontradoException.class)
    public ResponseEntity<Error>ManejarComentarioNoEncontradoException(ComentarioNoEncontradoException ex){
        Error error=new Error(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EtiquetaNoEncontradaException.class)
    public ResponseEntity<Error>ManejarEtiquetaNoEncontradaException(EtiquetaNoEncontradaException ex){
        Error error=new Error( 
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostNoEncontradoException.class)
    public ResponseEntity<Error>ManejarPostNoEncontradoException(PostNoEncontradoException ex){
        Error error=new Error( 
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<Error>ManejarUsuarioNoEncontradoException(UsuarioNoEncontradoException ex){
        Error error=new Error(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
