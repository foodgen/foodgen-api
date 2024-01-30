package com.genfood.foodgenback.service;

import com.genfood.foodgenback.endpoint.rest.model.Principal;
import com.genfood.foodgenback.model.User;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.getUserByEmail(username);
    if (Objects.isNull(user)) {
      throw new UsernameNotFoundException("User of email: " + username + " not found");
    }
    return Principal.builder().user(user).build();
  }
}
