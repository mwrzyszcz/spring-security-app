package pl.security.springsecurityapp.exception;

public class EmailConflictException extends RuntimeException {

  public EmailConflictException(String message) {
    super(message);
  }
}
