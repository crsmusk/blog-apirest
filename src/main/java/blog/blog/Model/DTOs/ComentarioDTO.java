package blog.blog.Model.DTOs;

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
@Getter
@Setter
public class ComentarioDTO {
     private Long id;
     private @NonNull String nickNameCreador;
     private String cuerpoComentario;
    
}
