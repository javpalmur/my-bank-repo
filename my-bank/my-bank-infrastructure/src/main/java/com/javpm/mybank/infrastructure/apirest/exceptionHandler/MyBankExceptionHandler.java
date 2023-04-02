package com.javpm.mybank.infrastructure.apirest.exceptionHandler;

import com.javpm.mybank.domain.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyBankExceptionHandler {

  @ExceptionHandler(value = NotFoundException.class)
  public ResponseEntity<Object> handleNotFoundException() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<Object> handleGenericException() {
    return ResponseEntity.internalServerError().build();
  }
}
