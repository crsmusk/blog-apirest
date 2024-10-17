package blog.blog.Exception.Exceptions;

public class noHayContenido extends RuntimeException{
    public noHayContenido(){
        super("no hay contenido");
    }
}
