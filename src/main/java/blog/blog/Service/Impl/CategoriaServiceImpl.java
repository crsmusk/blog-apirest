package blog.blog.Service.Impl;

import java.util.List;
import java.util.Optional;

import blog.blog.Exception.Exceptions.noHayContenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.blog.Exception.Exceptions.CategoriaNoEncontradaException;
import blog.blog.Mapper.CategoriaMapper;
import blog.blog.Model.DTOs.CategoriaDTO;
import blog.blog.Model.Entities.Categoria;
import blog.blog.Repository.CategoriaRepository;
import blog.blog.Service.Interface.ICategoria;
@Service
public class CategoriaServiceImpl implements ICategoria{

    @Autowired
    CategoriaRepository categoriaRepo;
    @Autowired
    CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> getAllCategoria() {
        List<Categoria>categorias=categoriaRepo.findAll();
        if (categorias.isEmpty()){
            throw new noHayContenido();
        }else{
            return categoriaMapper.toCategoriasDTO(categorias);
        }

    }

    @Override
    public CategoriaDTO findByNombre(String nombre) {
        Optional<Categoria>categoria=categoriaRepo.findByNombreCategoria(nombre);
       if(categoria.isPresent()){
        return categoriaMapper.toCategoriaDto(categoria.get());
       }else{
        throw new CategoriaNoEncontradaException("no se encontro la categoria con el nombre "+nombre);
       }
    }

    @Override
    public CategoriaDTO save(CategoriaDTO CategoriaDt) {
       Categoria categoria=new Categoria();
       categoria.setNombreCategoria(CategoriaDt.getNombreCategoria());
       categoriaRepo.save(categoria);
       return categoriaMapper.toCategoriaDto(categoria);
    }

    @Override
    public CategoriaDTO update(Long id, CategoriaDTO categoriaDt) {
      if (categoriaRepo.existsById(id)) {
         Categoria categoria=categoriaRepo.findById(id).get();
         categoria.setNombreCategoria(categoriaDt.getNombreCategoria());
         categoriaRepo.save(categoria);
         return categoriaMapper.toCategoriaDto(categoria);
      }else{
        throw new CategoriaNoEncontradaException("no se encontro la categoria con el id"+id);
      }
    }

    @Override
    public void deleteById(Long id) {
        if (categoriaRepo.existsById(id)){
            categoriaRepo.deleteById(id);
        }else{
            throw new CategoriaNoEncontradaException("no se encontro la categoria con el id"+id);
        }

    }

   @Override
   public CategoriaDTO findById(Long id) {
        Optional<Categoria>categoria=categoriaRepo.findById(id);
      if(categoria.isPresent()){
         return categoriaMapper.toCategoriaDto(categoria.get());
        }else{
         throw new CategoriaNoEncontradaException("no se encontro la categoria con el id "+id);
        }
   }

}
