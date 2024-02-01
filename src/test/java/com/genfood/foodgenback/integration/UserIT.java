package com.genfood.foodgenback.integration;

import com.genfood.foodgenback.conf.FacadeIT;
import com.genfood.foodgenback.endpoint.controller.UserController;
import com.genfood.foodgenback.endpoint.rest.mapper.UserMapper;
import com.genfood.foodgenback.endpoint.rest.model.User;
import com.genfood.foodgenback.repository.UserRepository;
import com.genfood.foodgenback.repository.validator.MailValidator;
import com.genfood.foodgenback.service.AuthService;
import com.genfood.foodgenback.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.util.List;
import static com.genfood.foodgenback.utils.UserUtils.USER1_USERNAME;
import static com.genfood.foodgenback.utils.UserUtils.USER3_USERNAME;
import static com.genfood.foodgenback.utils.UserUtils.auth1;
import static com.genfood.foodgenback.utils.UserUtils.signUp4;
import static com.genfood.foodgenback.utils.UserUtils.updatedUser3;
import static com.genfood.foodgenback.utils.UserUtils.user1;
import static com.genfood.foodgenback.utils.UserUtils.user2;
import static com.genfood.foodgenback.utils.UserUtils.user3;

@Testcontainers
@Slf4j
//TODO: test and fix if it doesn't work
public class UserIT extends FacadeIT {
    UserController userController;
    UserService userService;

    AuthService authService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    MailValidator mailValidator;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, mailValidator);
        userController = new UserController(userMapper, userService, authService);
    }

    @Test
    void read_user_by_id() {
        User actual = userController.getByUserName(USER1_USERNAME);
        Assertions.assertEquals(user1(), actual);
    }

    @Test
    void crupdate_user() {
        userController.crupdateUsers(List.of(user1(), user2(), user3()));
        userController.crupdateUsers(List.of(updatedUser3()));
        User actual = userController.getByUserName(USER3_USERNAME);
        Assertions.assertEquals(updatedUser3(), actual);
    }

    @Test
    void sign_up() {
        Assertions.assertEquals(String.class, userController.signUp(signUp4()).getClass());
    }

    @Test
    void sign_in() {
        Assertions.assertEquals(String.class, userController.signIn(auth1()).getClass());
    }
}

