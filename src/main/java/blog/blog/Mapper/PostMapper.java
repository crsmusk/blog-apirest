package blog.blog.Mapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import blog.blog.Model.Entities.Comentario;
import org.springframework.stereotype.Component;

import blog.blog.Model.DTOs.PostDTO;

import blog.blog.Model.Entities.Post;

@Component
public class PostMapper {

    public PostDTO toPostDto(Post post){
        return PostDTO.builder()
                .id(post.getId())
        .titulo(post.getTitulo())
        .fechaPublicacion(post.getFechaPublicacion())
        .contenido(post.getContenido())
        .nickNameCreador(post.getUsuario().getNickName())
        .categoria(post.getCategoria().getNombreCategoria())
        .etiquetas(post.getEtiquetas().stream().map(Etiqueta->Etiqueta.getNombreEtiqueta()).toList())
                .comentarios( Optional.ofNullable(post.getComentarios())
                        .map(comentarios -> comentarios.stream()
                                .map(Comentario::getCuerpoComentario)
                                .toList())
                        .orElse(Collections.emptyList()))
        .build();
    }

    public List<PostDTO>toPostsDto(List<Post> posts){
      return posts.stream().map(this::toPostDto).toList();
    }


}
