package pl.security.springsecurityapp.dto;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class JwtDto {
  private final String accessToken;
  private final String tokenType;
}
