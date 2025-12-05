package com.museo.api.museo_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.museo.api.museo_api.service.PrincipalMakerService;
import com.museo.api.museo_api.dto.request.PrincipalMakerRequestDTO;
import com.museo.api.museo_api.dto.response.PrincipalMakerResponseDTO;
import java.util.List;

/**
 * Controlador REST para artistas.
 * Expone endpoints HTTP para operaciones CRUD sobre artistas.
 * Maneja validaciones de entrada y retorna respuestas HTTP apropiadas.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/principalmaker")
public class PrincipalMakerController {
  private final PrincipalMakerService principalMakerService;

  @Autowired
  public PrincipalMakerController(PrincipalMakerService principalMakerService) {
    this.principalMakerService = principalMakerService;
  }

  @GetMapping
  public ResponseEntity<List<PrincipalMakerResponseDTO>> getAll() {
    List<PrincipalMakerResponseDTO> listMakers = principalMakerService.findAll();
    return ResponseEntity.ok(listMakers);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PrincipalMakerResponseDTO> getById(@PathVariable Integer id) {
    PrincipalMakerResponseDTO maker = principalMakerService.findById(id);
    return ResponseEntity.ok(maker);
  }

  @PostMapping
  public ResponseEntity<PrincipalMakerResponseDTO> create(@RequestBody PrincipalMakerRequestDTO principalMakerDto) {
    PrincipalMakerResponseDTO created = principalMakerService.create(principalMakerDto);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PrincipalMakerResponseDTO> update(@PathVariable Integer id,
      @RequestBody PrincipalMakerRequestDTO principalMakerDto) {
    PrincipalMakerResponseDTO updated = principalMakerService.update(id, principalMakerDto);

    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    principalMakerService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
