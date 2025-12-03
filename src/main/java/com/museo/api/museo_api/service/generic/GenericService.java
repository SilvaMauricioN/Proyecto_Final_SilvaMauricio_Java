package com.museo.api.museo_api.service.generic;

import java.util.List;

public interface GenericService<RequestDTO, ResponseDTO, ID> {

  ResponseDTO create(RequestDTO requestDTO);

  ResponseDTO findById(ID id);

  List<ResponseDTO> findAll();

  ResponseDTO update(ID id, RequestDTO requestDTO);

  void delete(ID id);
}
