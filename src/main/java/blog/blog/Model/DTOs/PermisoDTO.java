package blog.blog.Model.DTOs;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PermisoDTO {
    private Long id;
    private String nombrePermiso;
}
