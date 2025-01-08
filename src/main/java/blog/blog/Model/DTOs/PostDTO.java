package blog.blog.Model.DTOs;
import java.time.LocalDate;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PostDTO {
     private Long id;
     
     private @NonNull String titulo;
     private @NonNull LocalDate fechaPublicacion;
     private @NonNull String contenido;
     private @NonNull String nickNameCreador;
     private String categoria;
     private List<String>etiquetas;
     private List<String>comentarios;
}
