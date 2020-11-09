package pl.security.springsecurityapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class ErrorMessage {

  private final int status;
  private final String reason;
}
