package com.museo.api.museo_api.service;

import com.museo.api.museo_api.dto.request.PrincipalMakerRequestDTO;
import com.museo.api.museo_api.dto.response.PrincipalMakerResponseDTO;
import com.museo.api.museo_api.service.generic.GenericService;

public interface PrincipalMakerService
    extends GenericService<PrincipalMakerRequestDTO, PrincipalMakerResponseDTO, Integer> {
  PrincipalMakerResponseDTO findByName(String name);
}
