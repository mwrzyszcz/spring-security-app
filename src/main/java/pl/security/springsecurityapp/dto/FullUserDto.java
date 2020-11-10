package pl.security.springsecurityapp.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Builder
@Getter
@Setter
public class FullUserDto {
  private final Long id;
  private final String name;
  private final String email;
  private final Collection<? extends GrantedAuthority> authorities;
}
