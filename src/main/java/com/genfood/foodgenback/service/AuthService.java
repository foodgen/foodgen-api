package com.genfood.foodgenback.service;

import com.genfood.foodgenback.endpoint.rest.model.*;
import com.genfood.foodgenback.model.User;
import jakarta.transaction.Transactional;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
  private final UserService userService;
  private final UserDetailsServiceImpl userDetailsServiceImpl;
  private final JWTService jwtService;
  private final PasswordEncoder passwordEncoder;

  public LoggedUser signIn(SignInRequest signInUser) {
    String email = signInUser.getEmail();
    UserDetails principal = userDetailsServiceImpl.loadUserByUsername(email);
    if (!passwordEncoder.matches(signInUser.getPassword(), principal.getPassword())) {
      throw new UsernameNotFoundException("Wrong Password!");
    }
    User user = userService.getUserByEmail(email);
    String token = jwtService.generateToken(principal);
    return LoggedUser.builder()
        .id(user.getId())
        .username(user.getUsername())
        .email(user.getEmail())
        .role(user.getRole().name())
        .token(token)
        .build();
  }

  @Transactional
  public LoggedUser signUp(SignUpRequest user) {
    String email = user.getEmail();
    User existingUser = userService.getUserByEmail(email);
    if (Objects.nonNull(existingUser)) {
      throw new DuplicateKeyException("User with the email address: " + email + " already exists.");
    }
    String hashedPassword = passwordEncoder.encode(user.getPassword());
    User createdUser =
        userService.saveUser(
            User.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .role(Role.USER)
                .password(hashedPassword)
                .build());
    Principal principal = Principal.builder().user(createdUser).build();
    String token = jwtService.generateToken(principal);
    return LoggedUser.builder()
        .id(principal.getUser().getId())
        .username(principal.getUser().getUsername())
        .email(principal.getUsername())
        .role(principal.getUser().getRole().name())
        .token(token)
        .build();
  }
}
