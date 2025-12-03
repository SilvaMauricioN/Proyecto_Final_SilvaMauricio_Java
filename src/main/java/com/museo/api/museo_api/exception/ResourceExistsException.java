package com.museo.api.museo_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceExistsException extends RuntimeException {
  public ResourceExistsException(String message) {
    super(message);
  }
  
  public ResourceExistsException(String resourceName, String fieldName, Object fieldValue) {
    super(String.format("%s ya existe el recurso %s: '%s'", resourceName, fieldName, fieldValue));
  }  
}
