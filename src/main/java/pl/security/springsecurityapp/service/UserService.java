package pl.security.springsecurityapp.service;

import org.springframework.stereotype.Service;
import pl.security.springsecurityapp.dto.FullUserDto;
import pl.security.springsecurityapp.security.UserPrincipal;

@Service
public class UserService {

  public FullUserDto getCurrentUser(UserPrincipal userPrincipal) {
    return FullUserDto.builder()
        .id(userPrincipal.getId())
        .email(userPrincipal.getEmail())
        .name(userPrincipal.getName())
        .authorities(userPrincipal.getAuthorities())
        .build();
  }
}
