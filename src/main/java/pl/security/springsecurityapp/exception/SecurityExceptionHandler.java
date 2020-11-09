package pl.security.springsecurityapp.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class SecurityExceptionHandler {

  @ExceptionHandler({
    JsonProcessingException.class,
    IllegalArgumentException.class,
  })
  public ResponseEntity<ErrorMessage> handleProcessing(RuntimeException exception) {
    return ResponseEntity.status(BAD_REQUEST)
        .body(new ErrorMessage(BAD_REQUEST.value(), exception.getMessage()));
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorMessage> handleUser(UserNotFoundException userNotFoundException) {
    return ResponseEntity.status(NOT_FOUND)
        .body(new ErrorMessage(NOT_FOUND.value(), userNotFoundException.getMessage()));
  }

  @ExceptionHandler(EmailConflictException.class)
  public ResponseEntity<ErrorMessage> handleConflict(EmailConflictException conflictException) {
    return ResponseEntity.status(CONFLICT)
        .body(new ErrorMessage(CONFLICT.value(), conflictException.getMessage()));
  }

  @ExceptionHandler(RoleNotFoundException.class)
  public ResponseEntity<ErrorMessage> handleRole(RoleNotFoundException roleNotFoundException) {
    return ResponseEntity.status(NOT_FOUND)
        .body(new ErrorMessage(NOT_FOUND.value(), roleNotFoundException.getMessage()));
  }

  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<ErrorMessage> handleUnauthorized(
      UnauthorizedException unauthorizedException) {
    return ResponseEntity.status(UNAUTHORIZED)
        .body(new ErrorMessage(UNAUTHORIZED.value(), unauthorizedException.getMessage()));
  }
}
