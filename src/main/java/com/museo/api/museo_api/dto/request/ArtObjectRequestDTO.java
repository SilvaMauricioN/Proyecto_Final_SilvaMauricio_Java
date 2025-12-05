package com.museo.api.museo_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para recibir datos al crear o actualizar un objeto de arte.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtObjectRequestDTO {
  @NotBlank(message = "El número de objeto es obligatorio")
  private String objectNumber;

  private String title;
  private String longTitle;
  private Integer idPrincipalMaker;
  private Boolean hasImage;
  private String[] productionPlaces;
  private String description;
  private String plaqueDescription;
  private String[] materials;
  private String[] techniques;
  private String physicalMedium;
  private String scLabelLine;
  private String historicalDescription;
}
