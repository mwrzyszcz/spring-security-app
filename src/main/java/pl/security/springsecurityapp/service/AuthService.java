package pl.security.springsecurityapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.security.springsecurityapp.dto.*;
import pl.security.springsecurityapp.exception.EmailConflictException;
import pl.security.springsecurityapp.exception.RoleNotFoundException;
import pl.security.springsecurityapp.model.*;
import pl.security.springsecurityapp.repository.RoleRepository;
import pl.security.springsecurityapp.repository.UserRepository;
import pl.security.springsecurityapp.security.JwtTokenProvider;

@Service
@Log4j2
@RequiredArgsConstructor
public class AuthService {

  private static final String BEARER = "Bearer";
  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider tokenProvider;

  public JwtDto authenticate(LoginRequest loginRequest) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = tokenProvider.generateToken(authentication);
    return new JwtDto(jwt, BEARER);
  }

  public UserDto register(RegisterRequest registerRequest) {

    if (userRepository.existsByEmail(registerRequest.getEmail())) {
      throw new EmailConflictException("Email is already taken");
    }

    Role userRole =
        roleRepository
            .findByName(RoleName.ROLE_USER)
            .orElseThrow(() -> new RoleNotFoundException("Role not found!"));
    User user =
        new User(
            registerRequest.getName(),
            registerRequest.getEmail(),
            passwordEncoder.encode(registerRequest.getPassword()),
            userRole);

    User savedUser = userRepository.save(user);
    return UserDto.builder().name(savedUser.getName()).email(savedUser.getEmail()).build();
  }
}
