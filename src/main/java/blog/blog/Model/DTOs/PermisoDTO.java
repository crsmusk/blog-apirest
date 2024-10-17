package blog.blog.Model.DTOs;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PermisoDTO {
    Long id;
    String nombrePermiso;
}
