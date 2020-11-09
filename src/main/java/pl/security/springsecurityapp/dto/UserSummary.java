package pl.security.springsecurityapp.dto;

import lombok.*;

@Builder
@Getter
@Setter
public class UserSummary {
  private final Long id;
  private final String name;
  private final String email;
}
