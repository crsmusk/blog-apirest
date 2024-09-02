package blog.blog.Service.Impl;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ComentarioDTO> GetAllComentarios() {
       return comentariosMapper.toComentariosDto(comentarioRepo.findAll());
    }

    @Override
    public Optional<ComentarioDTO> FindById(Long id) {
       if(comentarioRepo.findById(id).isPresent()){
         return Optional.of(comentariosMapper.toComentarioDTO(comentarioRepo.findById(id).get()));
       }else{
        throw new ComentarioNoEncontradoException("no se econtro el comentario con el id "+id);
       }

    }

    
    @Override
    public Optional<ComentarioDTO> Update(Long id, ComentarioDTO comentari) {
        if(comentarioRepo.findById(id).isPresent()){
            Comentario comentario=comentarioRepo.findById(id).get();
            comentario.setCuerpoComentario(comentari.getCuerpoComentario());
            comentarioRepo.save(comentario);
            return Optional.of(comentariosMapper.toComentarioDTO(comentario));
        }else{
            throw new ComentarioNoEncontradoException("no se econtro el comentario con el id "+id);
        }

    }

    @Override
    public void DeleteById(Long id) {
       comentarioRepo.deleteById(id);
    }

    
    @Override
    @Transactional
    public Optional<ComentarioDTO> Save(Long idPost, ComentarioDTO comentario) {
        if (PostRepo.existsById(idPost)) {
            Comentario coment=new Comentario();
            coment.setPost(PostRepo.findById(idPost).get());
            coment.setCuerpoComentario(comentario.getCuerpoComentario());
            comentarioRepo.save(coment);
            return Optional.of(comentariosMapper.toComentarioDTO(coment));
        }else{
            throw new PostNoEncontradoException("no se econtro el post con el id "+idPost);
        }
    }

    @Override
    public Optional<List<ComentarioDTO>> findByContenidos(String contenido) {
        return Optional.of(comentariosMapper.toComentariosDto(comentarioRepo
        .findByCuerpoComentarioIgnoreCaseContaining(contenido))); 
    }

    

    @Override
    @Transactional
    public Optional<List<ComentarioDTO>> findByContenido(Long idPost, String contenido) {
       return Optional.of(comentariosMapper.toComentariosDto(comentarioRepo.findByCuerpoComentario(contenido, idPost)));
    }
    

}
