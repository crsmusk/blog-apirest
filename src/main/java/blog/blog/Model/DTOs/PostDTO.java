package blog.blog.Model.DTOs;
import java.time.LocalDate;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PostDTO {
    private String Titulo;
    private LocalDate FechaPublicacion;
    private String Contenido;
    private String NickNameCreador;
    private String categoria;
    private List<String>Etiquetas;
    private List<String>comentarios;
}
