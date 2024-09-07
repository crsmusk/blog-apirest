package blog.blog.Service.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import blog.blog.Exception.Exceptions.PostNoEncontradoException;
import blog.blog.Mapper.PostMapper;

import blog.blog.Model.DTOs.PostDTO;
import blog.blog.Model.Entities.Categoria;
import blog.blog.Model.Entities.Etiqueta;
import blog.blog.Model.Entities.Post;
import blog.blog.Model.Entities.Usuario;
import blog.blog.Repository.CategoriaRepository;
import blog.blog.Repository.EtiquetaRepository;
import blog.blog.Repository.PostRepository;
import blog.blog.Repository.UsuarioRepository;
import blog.blog.Service.Interface.IPost;
@Service
public class PostServiceImpl implements IPost {
    
    @Autowired
    UsuarioRepository usuarioRepo;
    @Autowired
    CategoriaRepository categoriaRepo;
    @Autowired
    EtiquetaRepository etiquetaRepo;
   
    @Autowired
    PostRepository postRepo;
    @Autowired
    PostMapper PostMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PostDTO> GetAllPosts() {
      return PostMapper.toPostsDto(postRepo.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostDTO> FindByPalabra(String palabra) {
        return PostMapper.toPostsDto(postRepo.findByCuerpoComentarioIgnoreCaseContaining(palabra));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostDTO> FindByTitulo(String titulo) {
       if (postRepo.findByTituloIgnoreCase(titulo).isEmpty()) {
        throw new PostNoEncontradoException("no se ningun post con el titulo "+titulo);
       }else{
        return PostMapper.toPostsDto(postRepo.findByTituloIgnoreCase(titulo));
       }
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostDTO> FindByDate(LocalDate fecha) {
        if(postRepo.findByFechaPublicacionLessThan(fecha).isEmpty()){
            throw new PostNoEncontradoException("no se encontro ningun post con la fecha "+fecha);
        }else{
            return PostMapper.toPostsDto(postRepo.findByFechaPublicacionLessThan(fecha));
        }
       
    }

    @Override
     @Transactional(readOnly = true)
    public Optional<PostDTO> FindById(Long id) {
        if (postRepo.findById(id).isPresent()) {
            return Optional.of(PostMapper.toPostDto(postRepo.findById(id).get()));
        }else{
            throw new PostNoEncontradoException("no se encontro el post con el id "+id);
        }
    }

 

    @Override
    @Transactional
    public Optional<PostDTO> Update (Long id, PostDTO postDt) {
       
        if (postRepo.existsById(id)) {
            Post post=postRepo.findById(id).get();
            Categoria categoria=categoriaRepo.findByNombreCategoria(postDt.getCategoria()).get();
            List<Etiqueta>listaEtiquetas=etiquetaRepo.findByNombreEtiquetaInIgnoreCase(postDt.getEtiquetas());
            post.setCategoria(categoria);
            post.setEtiquetas(listaEtiquetas);
            post.setFechaPublicacion(postDt.getFechaPublicacion());
            post.setTitulo(postDt.getTitulo());
            post.setContenido(postDt.getContenido());
            postRepo.save(post);
            return Optional.of(PostMapper.toPostDto(post));
        }else{
            throw new PostNoEncontradoException("no encontro el post con el id "+id);
        }
    }

    @Override
    public void DeleteById(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<PostDTO> Save(PostDTO postDt) {
        Post post=new Post();
        Categoria categoria=categoriaRepo.findByNombreCategoria(postDt.getCategoria()).get();
        List<Etiqueta>listaEtiquetas=etiquetaRepo.findByNombreEtiquetaInIgnoreCase(postDt.getEtiquetas());
        Usuario usuario=usuarioRepo.findByNickNameIgnoreCase(postDt.getNickNameCreador()).get();
        post.setCategoria(categoria);
        post.setEtiquetas(listaEtiquetas);
        post.setFechaPublicacion(postDt.getFechaPublicacion());
        post.setTitulo(postDt.getTitulo());
        post.setUsuario(usuario);
        post.setContenido(postDt.getContenido());
        postRepo.save(post);
        return Optional.of(postDt);
    }

}
