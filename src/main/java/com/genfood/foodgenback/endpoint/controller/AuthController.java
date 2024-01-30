package com.genfood.foodgenback.endpoint.rest.controller;

import com.genfood.foodgenback.endpoint.rest.model.LoggedUser;
import com.genfood.foodgenback.endpoint.rest.model.SignInRequest;
import com.genfood.foodgenback.endpoint.rest.model.SignUpRequest;
import com.genfood.foodgenback.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
  private final AuthService service;

  @PostMapping("/signup")
  public LoggedUser signUp(@RequestBody SignUpRequest userSignUp) {
    return service.signUp(userSignUp);
  }

  @PostMapping("/login")
  public LoggedUser signIn(@RequestBody SignInRequest userSignIn) {
    return service.signIn(userSignIn);
  }
}
