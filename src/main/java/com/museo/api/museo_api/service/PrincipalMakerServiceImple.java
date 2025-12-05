package com.museo.api.museo_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.museo.api.museo_api.dto.request.PrincipalMakerRequestDTO;
import com.museo.api.museo_api.dto.response.PrincipalMakerResponseDTO;
import com.museo.api.museo_api.exception.ResourceExistsException;
import com.museo.api.museo_api.exception.ResourceNotFoundException;
import com.museo.api.museo_api.mapper.PrincipalMakerMapper;
import com.museo.api.museo_api.model.PrincipalMaker;
import com.museo.api.museo_api.repository.PrincipalMakerRepository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * Servicio para gestionar artistas.
 * Implementa validaciones de negocio: verifica duplicados, existencia de
 * recursos.
 * Maneja transacciones y coordina entre repositorios y mappers.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class PrincipalMakerServiceImple implements PrincipalMakerService {
  private final PrincipalMakerRepository principalMakerRepository;
  private final PrincipalMakerMapper mapper;

  @Override
  public PrincipalMakerResponseDTO create(PrincipalMakerRequestDTO dto) {
    // Validar que no exista un maker con el mismo nombre
    if (principalMakerRepository.existsByName(dto.getName())) {
      throw new ResourceExistsException("PrincipalMaker", "name", dto.getName());
    }

    PrincipalMaker maker = mapper.toEntity(dto);
    PrincipalMaker saved = principalMakerRepository.save(maker);
    return mapper.toResponseDTO(saved);
  }

  @Override
  @Transactional(readOnly = true)
  public PrincipalMakerResponseDTO findById(Integer id) {
    PrincipalMaker maker = principalMakerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("PrincipalMaker", "id", id));
    return mapper.toResponseDTO(maker);
  }

  @Override
  @Transactional(readOnly = true)
  public PrincipalMakerResponseDTO findByName(String name) {
    PrincipalMaker maker = principalMakerRepository.findByName(name)
        .orElseThrow(() -> new ResourceNotFoundException("PrincipalMaker", "name", name));
    return mapper.toResponseDTO(maker);
  }

  @Override
  @Transactional(readOnly = true)
  public List<PrincipalMakerResponseDTO> findAll() {
    return principalMakerRepository.findAll().stream()
        .map(mapper::toResponseDTO)
        .collect(Collectors.toList());
  }

  @Override
  public PrincipalMakerResponseDTO update(Integer id, PrincipalMakerRequestDTO dto) {
    // Validar que el maker existe
    PrincipalMaker maker = principalMakerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("PrincipalMaker", "id", id));

    // Validar que el nuevo nombre no exista en otro registro
    if (principalMakerRepository.existsByNameAndIdPrincipalMakerNot(dto.getName(), id)) {
      throw new ResourceExistsException("PrincipalMaker", "name", dto.getName());
    }

    mapper.updateEntityFromDTO(dto, maker);
    PrincipalMaker updated = principalMakerRepository.save(maker);
    return mapper.toResponseDTO(updated);
  }

  @Override
  public void delete(Integer id) {
    // Validar que el maker existe antes de eliminar
    if (!principalMakerRepository.existsById(id)) {
      throw new ResourceNotFoundException("PrincipalMaker", "id", id);
    }
    principalMakerRepository.deleteById(id);
  }
}
