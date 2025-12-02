package com.museo.api.museo_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error -> {
      errors.put(error.getField(), error.getDefaultMessage());
    });
    
    Map<String, String> response = new HashMap<>();
    response.put("error", "Error de validación de la solicitud");
    response.putAll(errors);

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
    
  // Captura Error 404
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleNotFoundException(ResourceNotFoundException ex) {
    Map<String, String> error = new HashMap<>();
    error.put("error", "Recurso no encontrado");
    error.put("message", ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  // Captura 409
  @ExceptionHandler(ResourceExistsException.class)
  public ResponseEntity<Map<String, String>> handleConflictException(ResourceExistsException ex) {
    Map<String, String> error = new HashMap<>();
    error.put("error", "Conflicto de recursos");
    error.put("message", ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.CONFLICT);
  }  
}
