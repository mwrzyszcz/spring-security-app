package pl.security.springsecurityapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class RegisterRequest {
  @NotBlank
  @Size(min = 4, max = 40)
  private String name;

  @NotBlank
  @Size(max = 40)
  @Email
  private String email;

  @NotBlank
  @Size(min = 4, max = 30)
  private String password;
}
