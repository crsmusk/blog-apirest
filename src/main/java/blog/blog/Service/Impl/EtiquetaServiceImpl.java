package blog.blog.Service.Impl;

import java.util.List;
import java.util.Optional;

import blog.blog.Exception.Exceptions.noHayContenido;
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
    public List<EtiquetaDTO> getAllEtiquetas() {
        List<Etiqueta>etiquetas=etiquetaRepo.findAll();
        if (etiquetas.isEmpty()){
            throw new noHayContenido();
        }else{
            return etiquetaMapper.toEtiquetasDto(etiquetas);
        }

    }

    @Override
    public EtiquetaDTO findByNombreEtiqueta(String nombre) {
        Optional<Etiqueta>etiqueta=etiquetaRepo.findByNombreEtiquetaIgnoreCase(nombre);
        if(etiqueta.isPresent()){
            return etiquetaMapper.toEtiquetaDto(etiquetaRepo.findByNombreEtiquetaIgnoreCase(nombre).get());
        }else{
            throw new EtiquetaNoEncontradaException("no se encontro la etiqueta con el nombre "+nombre);
        }
    }

    @Override
    public EtiquetaDTO findById(Long id) {
       if(etiquetaRepo.findById(id).isPresent()){
         return etiquetaMapper.toEtiquetaDto(etiquetaRepo.findById(id).get());
       }else{
        throw new EtiquetaNoEncontradaException("no se encontro la etiqueta con el id "+id);
       }
    }

    @Override
    public EtiquetaDTO save(EtiquetaDTO etiquetaDt) {
        Etiqueta etiqueta=new Etiqueta();
        etiqueta.setNombreEtiqueta(etiquetaDt.getNombreEtiqueta());
        etiquetaRepo.save(etiqueta);
        return etiquetaMapper.toEtiquetaDto(etiqueta);
    }

    @Override
    public EtiquetaDTO update(Long id, EtiquetaDTO etiquetaDt) {
       if(etiquetaRepo.findById(id).isPresent()){
        Etiqueta etiqueta=etiquetaRepo.findById(id).get();
        etiqueta.setNombreEtiqueta(etiquetaDt.getNombreEtiqueta());
        etiquetaRepo.save(etiqueta);
        return etiquetaMapper.toEtiquetaDto(etiqueta);
        
       }else{
        throw new EtiquetaNoEncontradaException("no se encontro la etiqueta con el id "+id);
       }
    }

    @Override
    public void deleteById(Long id) {
        if (etiquetaRepo.existsById(id)){
            etiquetaRepo.deleteById(id);
        }else{
            throw new EtiquetaNoEncontradaException("no se encontro la etiqueta con el id "+id);
        }

    }

}
