package com.museo.api.museo_api.service.generic;

import java.util.List;

/**
 * Interfaz genérica que define operaciones CRUD estándar.
 * Todas las interfaces de servicio específicas heredan de esta.
 * Reduce duplicación de código y establece un contrato consistente.
 */
public interface GenericService<RequestDTO, ResponseDTO, ID> {

  ResponseDTO create(RequestDTO requestDTO);

  ResponseDTO findById(ID id);

  List<ResponseDTO> findAll();

  ResponseDTO update(ID id, RequestDTO requestDTO);

  void delete(ID id);
}
