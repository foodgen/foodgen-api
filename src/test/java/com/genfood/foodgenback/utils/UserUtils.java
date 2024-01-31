package com.genfood.foodgenback.utils;

import com.genfood.foodgenback.endpoint.rest.model.Recipe;
import com.genfood.foodgenback.endpoint.rest.model.Role;
import com.genfood.foodgenback.endpoint.rest.model.User;

public class UserUtils {

    public static final String USER1_ID = "user1_id";
    public static final String USER2_ID = "user2_id";
    public static final String USER3_ID = "user3_id";
    public static final String USER1_USERNAME = "user1_username";
    public static final String USER2_USERNAME = "user2_username";
    public static final String USER3_USERNAME = "user3_username";
    public static final String USER1_FIRSTNAME = "user1_firstname";
    public static final String USER2_FIRSTNAME = "user2_firstname";
    public static final String USER3_FIRSTNAME = "user3_firstname";
    public static final String USER1_LASTNAME = "user1_lastname";
    public static final String USER2_LASTNAME = "user2_lastname";
    public static final String USER3_LASTNAME = "user3_lastname";
    public static final String USER1_EMAIL = "user1@gmail.com";
    public static final String USER2_EMAIL = "user2@gmail.com";
    public static final String USER3_EMAIL = "user3@gmail.com";
    public static final String USER1_PASSWORD = "vide";
    public static final String USER2_PASSWORD = "vide";
    public static final String USER3_PASSWORD = "vide";
    public static final String USER1_ROLE = "USER";
    public static final String USER2_ROLE = "USER";
    public static final String USER3_ROLE = "ADMIN";

    public static final String UPDATED_USER3_USERNAME = "user3_name";

    public static User user1() {
        return User.builder()
                .id(USER1_ID)
                .username(USER1_USERNAME)
                .firstname(USER1_FIRSTNAME)
                .lastname(USER1_LASTNAME)
                .email(USER1_EMAIL)
                .password(USER1_PASSWORD)
                .role(Role.valueOf(USER1_ROLE))
                .build();
    }
    public static User user2() {
        return User.builder()
                .id(USER2_ID)
                .username(USER2_USERNAME)
                .firstname(USER2_FIRSTNAME)
                .lastname(USER2_LASTNAME)
                .email(USER2_EMAIL)
                .password(USER2_PASSWORD)
                .role(Role.valueOf(USER2_ROLE))
                .build();
    }
    public static User user3() {
        return User.builder()
                .id(USER3_ID)
                .username(USER3_USERNAME)
                .firstname(USER3_FIRSTNAME)
                .lastname(USER3_LASTNAME)
                .email(USER3_EMAIL)
                .password(USER3_PASSWORD)
                .role(Role.valueOf(USER3_ROLE))
                .build();
    }
    public static User updatedUser3() {
        return User.builder()
                .id(USER3_ID)
                .username(UPDATED_USER3_USERNAME)
                .firstname(USER3_FIRSTNAME)
                .lastname(USER3_LASTNAME)
                .email(USER3_EMAIL)
                .password(USER3_PASSWORD)
                .role(Role.valueOf(USER3_ROLE))
                .build();
    }
}
