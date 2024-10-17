package blog.blog.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import blog.blog.Model.DTOs.EtiquetaDTO;
import blog.blog.Model.Entities.Etiqueta;

@Component
public class EtiquetaMapper {
   public EtiquetaDTO toEtiquetaDto(Etiqueta etiqueta){
    return EtiquetaDTO.builder()
            .id(etiqueta.getId())
    .nombreEtiqueta(etiqueta.getNombreEtiqueta())
    .build();
   }

   public List<EtiquetaDTO> toEtiquetasDto(List<Etiqueta> etiquetas){
    return etiquetas.stream().map(this::toEtiquetaDto).toList();
   }
   
}
