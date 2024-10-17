package blog.blog.Mapper;


import java.util.List;

import org.springframework.stereotype.Component;

import blog.blog.Model.DTOs.ComentarioDTO;
import blog.blog.Model.Entities.Comentario;

@Component
public class ComentariosMapper {
   public ComentarioDTO toComentarioDTO(Comentario comentario){
    return ComentarioDTO.builder()
    .cuerpoComentario(comentario.getCuerpoComentario())
            .id(comentario.getId())
    .build();
   }

   public List<ComentarioDTO>toComentariosDto(List<Comentario> comentarios){
    return comentarios.stream().map(this::toComentarioDTO).toList();
   }
}
