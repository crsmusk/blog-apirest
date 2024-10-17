package blog.blog.Mapper;

import java.util.List;

import blog.blog.Model.Entities.Rol;
import org.springframework.stereotype.Component;

import blog.blog.Model.DTOs.UsuarioDTO;
import blog.blog.Model.Entities.Usuario;

@Component
public class UsuarioMapper {
  
   public UsuarioDTO toUsuarioDto(Usuario usuario){
    return UsuarioDTO.builder()
            .id(usuario.getId())
    .email(usuario.getEmail())
    .password(usuario.getPassword())
            .roles(usuario.getRoles().stream().map(Rol::getNombreRol).toList())
    .nickName(usuario.getNickName())
    .build();
   }

   public List<UsuarioDTO> toUsuariosDto(List<Usuario> usuarios){
    return usuarios.stream().map(this::toUsuarioDto).toList();
   }
}
