package pl.security.springsecurityapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.security.springsecurityapp.dto.FullUserDto;
import pl.security.springsecurityapp.security.CurrentUser;
import pl.security.springsecurityapp.security.UserPrincipal;
import pl.security.springsecurityapp.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  @GetMapping("/me")
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity<FullUserDto> getCurrentUser(@CurrentUser UserPrincipal currentUser) {
    return ResponseEntity.ok(userService.getCurrentUser(currentUser));
  }
}
