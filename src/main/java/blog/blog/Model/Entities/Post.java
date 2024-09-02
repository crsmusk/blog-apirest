package blog.blog.Model.Entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String titulo;
 private LocalDate fechaPublicacion;
 private String contenido;
 @OneToMany(mappedBy = "post",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
 private List<Comentario>comentarios;

 @ManyToMany
 @JoinTable(
    name = "Post_Etiqueta",
    joinColumns = @JoinColumn(name = "Post_id"),
    inverseJoinColumns = @JoinColumn(name = "Etiqueta_id")
 )
 private List<Etiqueta>Etiquetas;

 @ManyToOne
 @JoinColumn(name = "usuario_id")
 private Usuario usuario;
 @ManyToOne
 @JoinColumn(name = "categoria_id")
 private Categoria categoria;


}
