package blog.blog.Model.DTOs;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RolDTO {
    Long id;
    private @NonNull String nombreRol;
    private @NonNull List<String>nombrePermisos;
}
