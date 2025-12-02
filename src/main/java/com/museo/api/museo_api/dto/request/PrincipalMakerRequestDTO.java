package com.museo.api.museo_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
