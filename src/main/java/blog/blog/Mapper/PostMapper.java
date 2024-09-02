package blog.blog.Mapper;
import java.util.List;
import org.springframework.stereotype.Component;

import blog.blog.Model.DTOs.PostDTO;

import blog.blog.Model.Entities.Post;

@Component
public class PostMapper {

    public PostDTO toPostDto(Post post){
        return PostDTO.builder()
        .Titulo(post.getTitulo())
        .FechaPublicacion(post.getFechaPublicacion())
        .Contenido(post.getContenido())
        .NickNameCreador(post.getUsuario().getNickName())
        .categoria(post.getCategoria().getNombreCategoria())
        .Etiquetas(post.getEtiquetas().stream().map(Etiqueta->Etiqueta.getNombreEtiqueta()).toList())
        .comentarios(post.getComentarios().stream().map(Comentario->Comentario.getCuerpoComentario()).toList())
        .build();
    }

    public List<PostDTO>toPostsDto(List<Post> posts){
      return posts.stream().map(this::toPostDto).toList();
    }


}
