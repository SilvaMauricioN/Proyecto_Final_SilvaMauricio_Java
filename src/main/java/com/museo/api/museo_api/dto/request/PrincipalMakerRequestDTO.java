package com.museo.api.museo_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para recibir datos al crear o actualizar un artista.
 * Contiene validaciones (@NotBlank) para campos obligatorios.
 * No incluye el ID ya que se genera automáticamente.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalMakerRequestDTO {

  @NotBlank(message = "El nombre es obligatorio")
  private String name;
  private String placeOfBirth;
  private String dateOfBirth;
  private String dateOfDeath;
  private String placeOfDeath;
  private String nationality;
}
