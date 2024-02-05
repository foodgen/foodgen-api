package com.genfood.foodgenback.integration;

import static com.genfood.foodgenback.utils.UserUtils.USER1_USERNAME;
import static com.genfood.foodgenback.utils.UserUtils.USER3_USERNAME;
import static com.genfood.foodgenback.utils.UserUtils.auth4;
import static com.genfood.foodgenback.utils.UserUtils.signUp4;
import static com.genfood.foodgenback.utils.UserUtils.updatedUser3;
import static com.genfood.foodgenback.utils.UserUtils.user1;

import com.genfood.foodgenback.conf.FacadeIT;
import com.genfood.foodgenback.endpoint.controller.UserController;
import com.genfood.foodgenback.endpoint.rest.mapper.UserMapper;
import com.genfood.foodgenback.endpoint.rest.model.User;
import com.genfood.foodgenback.repository.UserRepository;
import com.genfood.foodgenback.repository.validator.MailValidator;
import com.genfood.foodgenback.service.AuthService;
import com.genfood.foodgenback.service.JWTService;
import com.genfood.foodgenback.service.UserDetailsServiceImpl;
import com.genfood.foodgenback.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@Slf4j
public class UserIT extends FacadeIT {
  UserController userController;
  UserService userService;

  AuthService authService;

  UserDetailsServiceImpl userDetailsService;
  @Autowired UserMapper userMapper;
  @Autowired MailValidator mailValidator;

  @Autowired UserRepository userRepository;

  @Autowired PasswordEncoder passwordEncoder;

  @Autowired JWTService jwtService;

  @BeforeEach
  void setUp() {
    userService = new UserService(userRepository, mailValidator);
    userDetailsService = new UserDetailsServiceImpl(userService);
    authService = new AuthService(userService, userDetailsService, jwtService, passwordEncoder);
    userController = new UserController(userMapper, userService, authService);
  }

  @Test
  void read_user_by_id() {
    User actual = userController.getByUserName(USER1_USERNAME);
    Assertions.assertEquals(user1(), actual);
  }

  @Test
  void crupdate_user() {
    userController.crupdateUsers(List.of(updatedUser3()));
    User actual = userController.getByUserName(USER3_USERNAME);
    Assertions.assertEquals(updatedUser3(), actual);
  }

  @Test
  void register() {
    Assertions.assertEquals(String.class, userController.signUp(signUp4()).getClass());
  }

  @Test
  void sign_in() {
    Assertions.assertEquals(String.class, userController.signIn(auth4()).getClass());
  }
}
