package com.museo.api.museo_api.service;

import com.museo.api.museo_api.dto.request.ArtObjectRequestDTO;
import com.museo.api.museo_api.dto.response.ArtObjectResponseDTO;
import com.museo.api.museo_api.exception.ResourceNotFoundException;
import com.museo.api.museo_api.exception.ResourceExistsException;
import com.museo.api.museo_api.mapper.ArtObjectMapper;
import com.museo.api.museo_api.model.ArtObject;
import com.museo.api.museo_api.model.PrincipalMaker;
import com.museo.api.museo_api.repository.ArtObjectRepository;
import com.museo.api.museo_api.repository.PrincipalMakerRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ArtObjectServiceImple implements ArtObjectService {
  private final ArtObjectRepository repository;
  private final PrincipalMakerRepository principalMakerRepository;
  private final ArtObjectMapper mapper;

  @Override
  public ArtObjectResponseDTO create(ArtObjectRequestDTO dto) {
    log.debug("Creando ArtObject con objectNumber: {}", dto.getObjectNumber());

    if (repository.existsByObjectNumber(dto.getObjectNumber())) {
      throw new ResourceExistsException("ArtObject", "objectNumber", dto.getObjectNumber());
    }
    ArtObject artObject = mapper.toEntity(dto);

    if (dto.getIdPrincipalMaker() != null) {
      PrincipalMaker maker = principalMakerRepository.findById(dto.getIdPrincipalMaker())
          .orElseThrow(() -> new ResourceNotFoundException("PrincipalMaker", "id", dto.getIdPrincipalMaker()));
      artObject.setPrincipalMaker(maker);
    }
    ArtObject saved = repository.save(artObject);
    log.info("ArtObject creado con id: {}", saved.getIdArtObject());
    return mapper.toResponseDTO(saved);
  }

  @Override
  @Transactional(readOnly = true)
  public ArtObjectResponseDTO findById(Integer id) {
    log.debug("Buscando ArtObject con id: {}", id);
    ArtObject artObject = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("ArtObject", "id", id));
    return mapper.toResponseDTO(artObject);
  }

  @Override
  @Transactional(readOnly = true)
  public List<ArtObjectResponseDTO> findAll() {
    log.debug("Obteniendo todos los ArtObjects");
    List<ArtObjectResponseDTO> artObjects = repository.findAll().stream()
        .map(mapper::toResponseDTO)
        .collect(Collectors.toList());
    log.info("Se encontraron {} ArtObjects", artObjects.size());
    return artObjects;
  }

  @Override
  public ArtObjectResponseDTO update(Integer id, ArtObjectRequestDTO dto) {
    log.debug("Actualizando ArtObject con id: {}", id);

    // Validar que el art object existe
    ArtObject artObject = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("ArtObject", "id", id));

    // Validar que el nuevo objectNumber no exista en otro registro
    if (repository.existsByObjectNumberAndIdArtObjectNot(dto.getObjectNumber(), id)) {
      log.warn("Intento de actualizar con objectNumber duplicado: {}", dto.getObjectNumber());
      throw new ResourceExistsException("ArtObject", "objectNumber", dto.getObjectNumber());
    }

    // Actualizar todos los campos
    mapper.updateEntityFromDTO(dto, artObject);

    // Actualizar la relación con PrincipalMaker
    if (dto.getIdPrincipalMaker() != null) {
      log.debug("Actualizando relación con PrincipalMaker id: {}", dto.getIdPrincipalMaker());
      PrincipalMaker maker = principalMakerRepository.findById(dto.getIdPrincipalMaker())
          .orElseThrow(() -> new ResourceNotFoundException("PrincipalMaker", "id", dto.getIdPrincipalMaker()));
      artObject.setPrincipalMaker(maker);
    } else {
      // Si no se proporciona idPrincipalMaker, se elimina la relación
      artObject.setPrincipalMaker(null);
    }

    ArtObject updated = repository.save(artObject);
    log.info("ArtObject actualizado exitosamente con id: {}", id);
    return mapper.toResponseDTO(updated);
  }

  @Override
  public void delete(Integer id) {
    log.debug("Eliminando ArtObject con id: {}", id);

    // Validar que el art object existe antes de eliminar
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException("ArtObject", "id", id);
    }

    repository.deleteById(id);
    log.info("ArtObject eliminado exitosamente con id: {}", id);
  }

  // ========== MÉTODOS ESPECÍFICOS DE ARTOBJECT ==========

  @Override
  @Transactional(readOnly = true)
  public ArtObjectResponseDTO findByObjectNumber(String objectNumber) {
    log.debug("Buscando ArtObject por objectNumber: {}", objectNumber);
    ArtObject artObject = repository.findByObjectNumber(objectNumber)
        .orElseThrow(() -> new ResourceNotFoundException("ArtObject", "objectNumber", objectNumber));
    return mapper.toResponseDTO(artObject);
  }
}
