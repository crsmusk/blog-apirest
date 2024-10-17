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
     Long id;
     String titulo;
     LocalDate fechaPublicacion;
     String contenido;
     String nickNameCreador;
     String categoria;
     List<String>etiquetas;
     List<String>comentarios;
}
