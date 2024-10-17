package blog.blog.Service.Impl;

import java.util.List;
import java.util.Optional;

import blog.blog.Exception.Exceptions.UsuarioNoEncontradoException;
import blog.blog.Exception.Exceptions.noHayContenido;
import blog.blog.Model.Entities.Post;
import blog.blog.Model.Entities.Usuario;
import blog.blog.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.blog.Exception.Exceptions.ComentarioNoEncontradoException;
import blog.blog.Exception.Exceptions.PostNoEncontradoException;
import blog.blog.Mapper.ComentariosMapper;
import blog.blog.Model.DTOs.ComentarioDTO;
import blog.blog.Model.Entities.Comentario;

import blog.blog.Repository.ComentarioRepository;
import blog.blog.Repository.PostRepository;
import blog.blog.Service.Interface.IComentario;
@Service
public class ComentarioServiceImpl implements IComentario{

    @Autowired 
    PostRepository PostRepo;

    @Autowired
    ComentarioRepository comentarioRepo;

    @Autowired
    ComentariosMapper comentariosMapper;
    @Autowired
    UsuarioRepository usuarioRepo;

    @Override
    public List<ComentarioDTO> getAllComentarios() {
        List<Comentario>comentarios=comentarioRepo.findAll();
        if (comentarios.isEmpty()){
            throw new noHayContenido();
        }else{
            return comentariosMapper.toComentariosDto(comentarios);
        }

    }

    @Override
    public ComentarioDTO findById(Long id) {
        Optional<Comentario>comentario=comentarioRepo.findById(id);
       if(comentario.isPresent()){
         return comentariosMapper.toComentarioDTO(comentario.get());
       }else{
        throw new ComentarioNoEncontradoException("no se econtro el comentario con el id "+id);
       }

    }

    
    @Override
    public ComentarioDTO update(Long id, ComentarioDTO comentari) {
        if(comentarioRepo.findById(id).isPresent()){
            Comentario comentario=comentarioRepo.findById(id).get();
            comentario.setCuerpoComentario(comentari.getCuerpoComentario());
            comentarioRepo.save(comentario);
            return comentariosMapper.toComentarioDTO(comentario);
        }else{
            throw new ComentarioNoEncontradoException("no se econtro el comentario con el id "+id);
        }

    }

    @Override
    public void deleteById(Long id) {
        if (comentarioRepo.existsById(id)){
            comentarioRepo.deleteById(id);
        }else{
            throw new ComentarioNoEncontradoException("no se econtro el comentario con el id "+id);
        }

    }

    
    @Override
    public ComentarioDTO save(Long idPost, ComentarioDTO comentario) {
        Optional<Post>post=PostRepo.findById(idPost);
        Optional<Usuario>usuario=usuarioRepo.findByNickNameIgnoreCase(comentario.getNickNameCreador());

        if (post.isPresent()) {
            Comentario Comentario=new Comentario();
             Comentario.setCuerpoComentario(comentario.getCuerpoComentario());
             Comentario.setPost(post.get());
             if (usuario.isPresent()){
                 Comentario.setUsuario(usuario.get());
             }else{
                 throw new UsuarioNoEncontradoException("no se encotro al usuario con el nickname "+comentario.getNickNameCreador());
             }
             comentarioRepo.save(Comentario);
            return comentariosMapper.toComentarioDTO(Comentario);
        }else{
            throw new PostNoEncontradoException("no se econtro el post con el id "+idPost);
        }
    }

    @Override
    public List<ComentarioDTO> findByContenidos(String contenido) {
        List<Comentario>comentarios=comentarioRepo
                .findByCuerpoComentarioIgnoreCaseContaining(contenido);
        if (comentarios.isEmpty()){
            throw new noHayContenido();
        }else {
            return comentariosMapper.toComentariosDto(comentarios);
        }
    }

    

    @Override
    @Transactional
    public List<ComentarioDTO> findByContenido(Long idPost, String contenido) {
        List<Comentario>comentarios=comentarioRepo.findByCuerpoComentario(contenido, idPost);
        if (comentarios.isEmpty()){
            throw new noHayContenido();
        }else{
            return comentariosMapper.toComentariosDto(comentarioRepo.findByCuerpoComentario(contenido, idPost));
        }

    }
    

}
