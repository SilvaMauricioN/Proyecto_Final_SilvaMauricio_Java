package com.museo.api.museo_api.service;

import com.museo.api.museo_api.dto.request.ArtObjectRequestDTO;
import com.museo.api.museo_api.dto.response.ArtObjectResponseDTO;
import com.museo.api.museo_api.service.generic.GenericService;

public interface ArtObjectService extends GenericService<ArtObjectRequestDTO,ArtObjectResponseDTO, Integer> {
  ArtObjectResponseDTO findByObjectNumber(String objectNumber);  
}