package com.genfood.foodgenback.endpoint.rest.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoggedUser implements Serializable {
  private String id;
  private String username;
  private String email;
  private String role;
  private String token;
}
