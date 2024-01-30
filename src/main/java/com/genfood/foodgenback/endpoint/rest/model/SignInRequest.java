package com.genfood.foodgenback.endpoint.rest.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignInRequest implements Serializable {
  // TODO: Validation
  private String email;
  private String password;
}
