package com.museo.api.museo_api.controller;

import com.museo.api.museo_api.dto.request.ArtObjectRequestDTO;
import com.museo.api.museo_api.dto.response.ArtObjectResponseDTO;
import com.museo.api.museo_api.service.ArtObjectService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de objetos de arte.
 * Proporciona endpoints para operaciones CRUD sobre obras de arte.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/artobjects")
// @RequiredArgsConstructor
public class ArtObjectController {
  private final ArtObjectService artObjectService;

  @Autowired
  public ArtObjectController(ArtObjectService artObjectService) {
    this.artObjectService = artObjectService;
  }

  @PostMapping
  public ResponseEntity<ArtObjectResponseDTO> create(
      @Valid @RequestBody ArtObjectRequestDTO dto) {
    ArtObjectResponseDTO created = artObjectService.create(dto);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ArtObjectResponseDTO> getById(@PathVariable Integer id) {
    ArtObjectResponseDTO artObject = artObjectService.findById(id);
    return ResponseEntity.ok(artObject);
  }

  @GetMapping
  public ResponseEntity<List<ArtObjectResponseDTO>> getAll() {
    List<ArtObjectResponseDTO> artObjects = artObjectService.findAll();
    return ResponseEntity.ok(artObjects);
  }

  @GetMapping("/search")
  public ResponseEntity<ArtObjectResponseDTO> getByObjectNumber(
      @RequestParam String objectNumber) {
    ArtObjectResponseDTO artObject = artObjectService.findByObjectNumber(objectNumber);
    return ResponseEntity.ok(artObject);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ArtObjectResponseDTO> update(
      @PathVariable Integer id,
      @Valid @RequestBody ArtObjectRequestDTO dto) {
    ArtObjectResponseDTO updated = artObjectService.update(id, dto);
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    artObjectService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
