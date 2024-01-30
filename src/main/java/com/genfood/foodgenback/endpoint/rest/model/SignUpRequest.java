package com.genfood.foodgenback.endpoint.rest.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignUpRequest implements Serializable {
  private String username;
  // TODO: validation
  private String email;
  private String password;
}
