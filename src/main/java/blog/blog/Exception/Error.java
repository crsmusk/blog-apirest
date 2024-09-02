package blog.blog.Exception;



public class Error {
    private int estado;
    private String mensaje;
    private Long tiempo;
    public Error(int estado, String mensaje, Long tiempo) {
       this.estado = estado;
       this.mensaje = mensaje;
       this.tiempo = tiempo;
    }
   public int getEstado() {
       return estado;
   }
   public void setEstado(int estado) {
       this.estado = estado;
   }
   public String getMensaje() {
       return mensaje;
   }
   public void setMensaje(String mensaje) {
       this.mensaje = mensaje;
   }
   public Long getTiempo() {
       return tiempo;
   }
   public void setTiempo(Long tiempo) {
       this.tiempo = tiempo;
   }
   
}
