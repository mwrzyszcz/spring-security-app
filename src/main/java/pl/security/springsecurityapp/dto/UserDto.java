package pl.security.springsecurityapp.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class UserDto {

  private String name;
  private String email;
}
