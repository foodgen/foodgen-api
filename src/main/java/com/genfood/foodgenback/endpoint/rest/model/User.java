package com.genfood.foodgenback.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
  private String id;
  private String username;
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private Role role;
}
