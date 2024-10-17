package blog.blog.Service.Interface;
import java.util.List;
import java.util.Optional;

import blog.blog.Model.DTOs.EtiquetaDTO;
public interface IEtiqueta {
  
    public List<EtiquetaDTO>getAllEtiquetas();
    public EtiquetaDTO findByNombreEtiqueta(String nombre);
    public EtiquetaDTO findById(Long id);
    public EtiquetaDTO save(EtiquetaDTO etiquetaDt);
    public EtiquetaDTO update(Long id,EtiquetaDTO etiquetaDt);
    public void deleteById(Long id);
    
} 
