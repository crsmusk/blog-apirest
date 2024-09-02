package blog.blog.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.blog.Exception.Exceptions.EtiquetaNoEncontradaException;
import blog.blog.Mapper.EtiquetaMapper;
import blog.blog.Model.DTOs.EtiquetaDTO;
import blog.blog.Model.Entities.Etiqueta;
import blog.blog.Repository.EtiquetaRepository;
import blog.blog.Service.Interface.IEtiqueta;
@Service
public class EtiquetaServiceImpl implements IEtiqueta{

    @Autowired 
    EtiquetaMapper etiquetaMapper;
    @Autowired 
    EtiquetaRepository etiquetaRepo;

    @Override
    public List<EtiquetaDTO> GetAllEtiquetas() {
      return etiquetaMapper.toEtiquetasDto(etiquetaRepo.findAll());
    }

    @Override
    public Optional<EtiquetaDTO> findByNombreEtiqueta(String nombre) {
        if(etiquetaRepo.findByNombreEtiquetaIgnoreCase(nombre).isPresent()){
            return Optional.of(etiquetaMapper.toEtiquetaDto(etiquetaRepo.findByNombreEtiquetaIgnoreCase(nombre).get()));
        }else{
            throw new EtiquetaNoEncontradaException("no se encontro la etiqueta con el nombre "+nombre);
        }
    }

    @Override
    public Optional<EtiquetaDTO> FindById(Long id) {
       if(etiquetaRepo.findById(id).isPresent()){
         return Optional.of(etiquetaMapper.toEtiquetaDto(etiquetaRepo.findById(id).get()));
       }else{
        throw new EtiquetaNoEncontradaException("no se encontro la etiqueta con el id "+id);
       }
    }

    @Override
    public Optional<EtiquetaDTO> Save(EtiquetaDTO etiquetaDt) {
        Etiqueta etiqueta=new Etiqueta();
        etiqueta.setNombreEtiqueta(etiquetaDt.getNombreEtiqueta());
        etiquetaRepo.save(etiqueta);
        return Optional.of(etiquetaMapper.toEtiquetaDto(etiqueta));
    }

    @Override
    public Optional<EtiquetaDTO> Update(Long id, EtiquetaDTO etiquetaDt) {
       if(etiquetaRepo.findById(id).isPresent()){
        Etiqueta etiqueta=etiquetaRepo.findById(id).get();
        etiqueta.setNombreEtiqueta(etiquetaDt.getNombreEtiqueta());
        etiquetaRepo.save(etiqueta);
        return Optional.of(etiquetaMapper.toEtiquetaDto(etiqueta));
        
       }else{
        throw new EtiquetaNoEncontradaException("no se encontro la etiqueta con el id "+id);
       }
    }

    @Override
    public void DeleteById(Long id) {
       etiquetaRepo.deleteById(id);
    }

}
