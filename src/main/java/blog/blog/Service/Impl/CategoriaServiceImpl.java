package blog.blog.Service.Impl;

import java.util.List;
import java.util.Optional;

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
    public List<CategoriaDTO> GetAllCategoria() {
       return categoriaMapper.toCategoriasDTO(categoriaRepo.findAll());
    }

    @Override
    public Optional<CategoriaDTO> FindByNombre(String nombre) {
       if(categoriaRepo.findByNombreCategoria(nombre).isPresent()){
        return Optional.of(categoriaMapper.toCategoriaDto(categoriaRepo.findByNombreCategoria(nombre).get()));
       }else{
        throw new CategoriaNoEncontradaException("no se encontro la categoria con el nombre "+nombre);
       }
    }

    @Override
    public Optional<CategoriaDTO> Save(CategoriaDTO CategoriaDt) {
       Categoria categoria=new Categoria();
       categoria.setNombreCategoria(CategoriaDt.getNombreCategoria());
       categoriaRepo.save(categoria);
       return Optional.of(categoriaMapper.toCategoriaDto(categoria));
    }

    @Override
    public Optional<CategoriaDTO> Update(Long id, CategoriaDTO categoriaDt) {
      if (categoriaRepo.existsById(id)) {
         Categoria categoria=categoriaRepo.findById(id).get();
         categoria.setNombreCategoria(categoriaDt.getNombreCategoria());
         categoriaRepo.save(categoria);
         return Optional.of(categoriaMapper.toCategoriaDto(categoria));
      }else{
        throw new CategoriaNoEncontradaException("no se encontro la categoria con el id"+id);
      }
    }

    @Override
    public void DeleteById(Long id) {
       categoriaRepo.deleteById(id);
    }

   @Override
   public Optional<CategoriaDTO> FindById(Long id) {
      if(categoriaRepo.findById(id).isPresent()){
         return Optional.of(categoriaMapper.toCategoriaDto(categoriaRepo.findById(id).get()));
        }else{
         throw new CategoriaNoEncontradaException("no se encontro la categoria con el id "+id);
        }
   }

}
