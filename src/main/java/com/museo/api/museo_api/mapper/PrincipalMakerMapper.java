package com.museo.api.museo_api.mapper;

import com.museo.api.museo_api.dto.request.PrincipalMakerRequestDTO;
import com.museo.api.museo_api.dto.response.PrincipalMakerResponseDTO;
import com.museo.api.museo_api.model.PrincipalMaker;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre PrincipalMaker (entidad) y sus DTOs.
 * Separa la capa de persistencia de la capa de presentación.
 * Evita exponer la estructura interna de la base de datos al cliente.
 */
@Component
public class PrincipalMakerMapper {
  public PrincipalMaker toEntity(PrincipalMakerRequestDTO dto) {
    PrincipalMaker maker = new PrincipalMaker();
    maker.setName(dto.getName());
    maker.setPlaceOfBirth(dto.getPlaceOfBirth());
    maker.setDateOfBirth(dto.getDateOfBirth());
    maker.setDateOfDeath(dto.getDateOfDeath());
    maker.setPlaceOfDeath(dto.getPlaceOfDeath());
    maker.setNationality(dto.getNationality());
    return maker;
  }

  public PrincipalMakerResponseDTO toResponseDTO(PrincipalMaker maker) {
    return new PrincipalMakerResponseDTO(
        maker.getIdPrincipalMaker(),
        maker.getName(),
        maker.getPlaceOfBirth(),
        maker.getDateOfBirth(),
        maker.getDateOfDeath(),
        maker.getPlaceOfDeath(),
        maker.getNationality());
  }

  public void updateEntityFromDTO(PrincipalMakerRequestDTO dto, PrincipalMaker maker) {
    maker.setName(dto.getName());
    maker.setPlaceOfBirth(dto.getPlaceOfBirth());
    maker.setDateOfBirth(dto.getDateOfBirth());
    maker.setDateOfDeath(dto.getDateOfDeath());
    maker.setPlaceOfDeath(dto.getPlaceOfDeath());
    maker.setNationality(dto.getNationality());
  }
}
