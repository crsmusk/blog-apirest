package blog.blog.Service.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import blog.blog.Exception.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public List<PostDTO> getAllPosts() {
        List<Post>lista=postRepo.findAll();
        if (lista.isEmpty()){
            throw new noHayContenido();
        }else {
            return PostMapper.toPostsDto(lista);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<PostDTO> findByPalabra(String palabra) {
        List<Post>posts=postRepo.findByCuerpoComentarioIgnoreCaseContaining(palabra);
        if (posts.isEmpty()){
            throw new noHayContenido();
        }else {
            return PostMapper.toPostsDto(posts);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostDTO> findByTitulo(String titulo) {
        List<Post>posts=postRepo.findByTituloIgnoreCase(titulo);
       if (posts.isEmpty()) {
        throw new noHayContenido();
       }else{
        return PostMapper.toPostsDto(posts);
       }
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostDTO> findByDate(LocalDate fecha) {
        List<Post>posts=postRepo.findByFechaPublicacionLessThan(fecha);
        if(posts.isEmpty()){
            throw new noHayContenido();
        }else{
            return PostMapper.toPostsDto(posts);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public PostDTO findById(Long id) {
        Optional<Post>post=postRepo.findById(id);
        if (post.isPresent()) {
            return PostMapper.toPostDto(post.get());
        }else{
            throw new PostNoEncontradoException("no se encontro el post con el id "+id);
        }
    }


    @Override
    @Transactional
    public PostDTO update (Long id, PostDTO postDt) {
       
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
            return PostMapper.toPostDto(post);
        }else{
            throw new PostNoEncontradoException("no encontro el post con el id "+id);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (postRepo.existsById(id)){
            postRepo.deleteById(id);
        }else {
            throw new PostNoEncontradoException("no se encontro el post con el id "+id);
        }

    }

    @Override
    @Transactional
    public PostDTO save(PostDTO postDt) {
        Post post=new Post();
        Optional<Categoria>categoria=categoriaRepo.findByNombreCategoria(postDt.getCategoria());

        if (categoria.isPresent()){
            post.setCategoria(categoria.get());
        }else {
            throw new CategoriaNoEncontradaException("no se encontro la categoria con el nombr "+postDt.getCategoria());
        }

        List<Etiqueta>etiquetas=new ArrayList<>();
        for (String i:postDt.getEtiquetas()){
            if (etiquetaRepo.findByNombreEtiquetaIgnoreCase(i).isPresent()){
                etiquetas.add(etiquetaRepo.findByNombreEtiquetaIgnoreCase(i).get());
            }else{
                throw new EtiquetaNoEncontradaException("no se encontro la etiqueta con el nombre "+i);
            }
            post.setEtiquetas(etiquetas);
        }

        Optional<Usuario>usuario=usuarioRepo.findByNickNameIgnoreCase(postDt.getNickNameCreador());
        if (usuario.isPresent()){
            post.setUsuario(usuario.get());
        }else {
            throw new UsuarioNoEncontradoException("no se encontro al usuario con el nickname "+postDt.getNickNameCreador());
        }

        post.setTitulo(postDt.getTitulo());
        post.setContenido(postDt.getContenido());
        post.setFechaPublicacion(postDt.getFechaPublicacion());
        postRepo.save(post);

        return PostMapper.toPostDto(post);
    }

}
