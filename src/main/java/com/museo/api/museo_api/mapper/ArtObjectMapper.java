package com.museo.api.museo_api.mapper;

import org.springframework.stereotype.Component;
import com.museo.api.museo_api.dto.request.ArtObjectRequestDTO;
import com.museo.api.museo_api.dto.response.ArtObjectResponseDTO;
import com.museo.api.museo_api.model.ArtObject;
import lombok.extern.slf4j.Slf4j;

/**
 * Mapper para convertir entre ArtObject y sus DTOs.
 * Además de mapear campos básicos, extrae las URLs de las imágenes asociadas
 * y obtiene el nombre del artista para incluirlos en la respuesta.
 */
@Slf4j
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
      try {
        dto.setIdPrincipalMaker(artObject.getPrincipalMaker().getIdPrincipalMaker());
        dto.setPrincipalMakerName(artObject.getPrincipalMaker().getName());
      } catch (Exception e) {
        log.warn("Error al cargar PrincipalMaker para ArtObject {}: {}",
            artObject.getIdArtObject(), e.getMessage());
        dto.setIdPrincipalMaker(null);
        dto.setPrincipalMakerName("Unknown Artist");
      }
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

    try {
      if (artObject.getWebImage() != null) {
        dto.setImageUrl(artObject.getWebImage().getUrl());
      } else {
        dto.setImageUrl(null);
      }
    } catch (Exception e) {
      log.warn("Error al cargar WebImage para ArtObject {}: {}",
          artObject.getIdArtObject(), e.getMessage());
      dto.setImageUrl(null);
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
