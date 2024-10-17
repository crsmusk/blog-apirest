package blog.blog.Model.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_rol")
    private String nombreRol;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
            @JoinTable(name = "rol_permiso",
                    joinColumns = @JoinColumn(name = "rol_id"),
                    inverseJoinColumns = @JoinColumn(name = "permiso_id"))
    List<Permiso>permisos;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

}
