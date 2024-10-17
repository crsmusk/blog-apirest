package blog.blog.Model.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long Id;
 @Column(unique = true)
 private String email;
 private String password;
 private String nickName;
 @Column(name = "is_enable")
 private Boolean isEnable=true;
 @Column(name = "account_no_locked")
 private Boolean accountNoLocked=true;
 @Column(name = "account_no_expired")
 private Boolean accountNoExpired=true;
 @Column(name = "credential_no_expired")
 private Boolean credentialNoExpired=true;
 @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
 private List<Comentario>Comentarios;
 
 @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
 private List<Post>posts;

 @ManyToMany(fetch = FetchType.EAGER)
         @JoinTable(name = "usuario_rol",joinColumns = @JoinColumn(name = "usuario_id"),inverseJoinColumns = @JoinColumn(name = "rol_id"))
 List<Rol>roles;
}
