package com.museo.api.museo_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebImageRequestDTO {
  @NotNull(message = "El ID del objeto de arte es obligatorio")
  private Integer idArtObject;
  
  private Integer width;
  private Integer height;
  
  @NotBlank(message = "La URL es obligatoria")
  private String url;
}
