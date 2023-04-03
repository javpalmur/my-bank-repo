package org.javpm.mybank.domain.exceptions;

public class NotFoundException extends RuntimeException {

  public NotFoundException(final String message) {
    super(message);
  }
}
