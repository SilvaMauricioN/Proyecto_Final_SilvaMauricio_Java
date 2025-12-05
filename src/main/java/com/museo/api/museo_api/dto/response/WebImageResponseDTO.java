package com.museo.api.museo_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para enviar datos de una imagen al cliente.
 * Incluye información del objeto de arte asociado.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebImageResponseDTO {
  private Integer idWebImage;
  private Integer idArtObject;
  private String artObjectTitle;
  private Integer width;
  private Integer height;
  private String url;
}
