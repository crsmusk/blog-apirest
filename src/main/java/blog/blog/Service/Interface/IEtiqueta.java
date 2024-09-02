package blog.blog.Service.Interface;
import java.util.List;
import java.util.Optional;

import blog.blog.Model.DTOs.EtiquetaDTO;
public interface IEtiqueta {
  
    public List<EtiquetaDTO>GetAllEtiquetas();
    public Optional<EtiquetaDTO>findByNombreEtiqueta(String nombre);
    public Optional<EtiquetaDTO>FindById(Long id);
    public Optional<EtiquetaDTO> Save(EtiquetaDTO etiquetaDt);
    public Optional<EtiquetaDTO> Update(Long id,EtiquetaDTO etiquetaDt);
    public void DeleteById(Long id);
    
} 
