package blog.blog.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import blog.blog.Model.DTOs.UsuarioDTO;
import blog.blog.Model.Entities.Usuario;

@Component
public class UsuarioMapper {
  
   public UsuarioDTO toUsuarioDto(Usuario usuario){
    return UsuarioDTO.builder()
    .Email(usuario.getEmail())
    .Password(usuario.getPassword())
    .NickName(usuario.getNickName())
    .build();
   }

   public List<UsuarioDTO> toUsuariosDto(List<Usuario> usuarios){
    return usuarios.stream().map(this::toUsuarioDto).toList();
   }
}
