package pl.security.springsecurityapp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.security.springsecurityapp.exception.UserNotFoundException;
import pl.security.springsecurityapp.model.User;
import pl.security.springsecurityapp.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) {
    User user =
        userRepository
            .findByEmail(email)
            .orElseThrow(() -> new UserNotFoundException("User not found"));

    return UserPrincipal.create(user);
  }

  public UserDetails loadUserById(Long id) {
    User user =
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

    return UserPrincipal.create(user);
  }
}
