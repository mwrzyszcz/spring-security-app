package pl.security.springsecurityapp.service;

import org.springframework.stereotype.Service;
import pl.security.springsecurityapp.dto.UserSummary;
import pl.security.springsecurityapp.security.UserPrincipal;

@Service
public class UserService {

  public UserSummary getCurrentUser(UserPrincipal userPrincipal) {
    return UserSummary.builder()
        .id(userPrincipal.getId())
        .email(userPrincipal.getEmail())
        .name(userPrincipal.getName())
        .build();
  }
}
