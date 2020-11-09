package pl.security.springsecurityapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.security.springsecurityapp.dto.*;
import pl.security.springsecurityapp.service.AuthService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/signin")
  public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginRequest loginRequest) {
    return ResponseEntity.ok(authService.authenticate(loginRequest));
  }

  @PostMapping("/signup")
  public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterRequest registerRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequest));
  }
}
