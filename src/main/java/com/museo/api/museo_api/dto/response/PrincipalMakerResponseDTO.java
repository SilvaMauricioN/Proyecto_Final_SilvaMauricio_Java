package com.museo.api.museo_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalMakerResponseDTO {
  private Integer idPrincipalMaker;
  private String name;
  private String placeOfBirth;
  private String dateOfBirth;
  private String dateOfDeath;
  private String placeOfDeath;
  private String nationality;
}
