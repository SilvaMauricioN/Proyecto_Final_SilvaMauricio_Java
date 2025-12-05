package com.museo.api.museo_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para enviar datos de un objeto de arte al cliente.
 * Incluye el nombre del artista y la URL de imágenes asociada.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtObjectResponseDTO {
  private Integer idArtObject;
  private String objectNumber;
  private String title;
  private String longTitle;
  private Integer idPrincipalMaker;
  private String principalMakerName;
  private Boolean hasImage;
  private String[] productionPlaces;
  private String description;
  private String plaqueDescription;
  private String[] materials;
  private String[] techniques;
  private String physicalMedium;
  private String scLabelLine;
  private String historicalDescription;
  private String imageUrl;
}
