package com.museo.api.museo_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción lanzada cuando se intenta crear un recurso que ya existe.
 * Se traduce a respuesta HTTP 409 (Conflict).
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceExistsException extends RuntimeException {
  public ResourceExistsException(String message) {
    super(message);
  }

  public ResourceExistsException(String resourceName, String fieldName, Object fieldValue) {
    super(String.format("%s: ya existe el recurso con %s: '%s'", resourceName, fieldName, fieldValue));
  }
}
