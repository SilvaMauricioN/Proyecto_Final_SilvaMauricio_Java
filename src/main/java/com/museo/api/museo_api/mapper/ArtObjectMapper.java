package com.museo.api.museo_api.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.museo.api.museo_api.dto.request.ArtObjectRequestDTO;
import com.museo.api.museo_api.dto.response.ArtObjectResponseDTO;
import com.museo.api.museo_api.model.ArtObject;
import com.museo.api.museo_api.model.WebImage;

@Component
public class ArtObjectMapper {
  public ArtObject toEntity(ArtObjectRequestDTO dto) {
    ArtObject artObject = new ArtObject();
    artObject.setObjectNumber(dto.getObjectNumber());
    artObject.setTitle(dto.getTitle());
    artObject.setLongTitle(dto.getLongTitle());
    artObject.setHasImage(dto.getHasImage());
    artObject.setProductionPlaces(dto.getProductionPlaces());
    artObject.setDescription(dto.getDescription());
    artObject.setPlaqueDescription(dto.getPlaqueDescription());
    artObject.setMaterials(dto.getMaterials());
    artObject.setTechniques(dto.getTechniques());
    artObject.setPhysicalMedium(dto.getPhysicalMedium());
    artObject.setScLabelLine(dto.getScLabelLine());
    artObject.setHistoricalDescription(dto.getHistoricalDescription());
    return artObject;
  }

  public ArtObjectResponseDTO toResponseDTO(ArtObject artObject) {
    ArtObjectResponseDTO dto = new ArtObjectResponseDTO();
    dto.setIdArtObject(artObject.getIdArtObject());
    dto.setObjectNumber(artObject.getObjectNumber());
    dto.setTitle(artObject.getTitle());
    dto.setLongTitle(artObject.getLongTitle());
    
    if (artObject.getPrincipalMaker() != null) {
      dto.setIdPrincipalMaker(artObject.getPrincipalMaker().getIdPrincipalMaker());
      dto.setPrincipalMakerName(artObject.getPrincipalMaker().getName());
    }
    
    dto.setHasImage(artObject.getHasImage());
    dto.setProductionPlaces(artObject.getProductionPlaces());
    dto.setDescription(artObject.getDescription());
    dto.setPlaqueDescription(artObject.getPlaqueDescription());
    dto.setMaterials(artObject.getMaterials());
    dto.setTechniques(artObject.getTechniques());
    dto.setPhysicalMedium(artObject.getPhysicalMedium());
    dto.setScLabelLine(artObject.getScLabelLine());
    dto.setHistoricalDescription(artObject.getHistoricalDescription());
    
    if (artObject.getWebImages() != null) {
      dto.setImageUrls(artObject.getWebImages().stream()
      .map(WebImage::getUrl)
      .collect(Collectors.toList()));
    }    
    return dto;
  }

  public void updateEntityFromDTO(ArtObjectRequestDTO dto, ArtObject artObject) {
    artObject.setObjectNumber(dto.getObjectNumber());
    artObject.setTitle(dto.getTitle());
    artObject.setLongTitle(dto.getLongTitle());
    artObject.setHasImage(dto.getHasImage());
    artObject.setProductionPlaces(dto.getProductionPlaces());
    artObject.setDescription(dto.getDescription());
    artObject.setPlaqueDescription(dto.getPlaqueDescription());
    artObject.setMaterials(dto.getMaterials());
    artObject.setTechniques(dto.getTechniques());
    artObject.setPhysicalMedium(dto.getPhysicalMedium());
    artObject.setScLabelLine(dto.getScLabelLine());
    artObject.setHistoricalDescription(dto.getHistoricalDescription());
  }    
  
}
