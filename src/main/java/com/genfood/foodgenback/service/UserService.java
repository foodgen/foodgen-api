package com.genfood.foodgenback.service;

import com.genfood.foodgenback.model.User;
import com.genfood.foodgenback.repository.UserRepository;
import com.genfood.foodgenback.repository.validator.MailValidator;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class UserService {
  private final UserRepository repository;
  private final MailValidator mailValidator;

  public User getUserByUsername(String userName) {
    return repository.findByUsername(userName);
  }

  public List<User> crupdateUsers(List<User> toCrupdate) {
    mailValidator.accept(toCrupdate);
    return repository.saveAll(toCrupdate);
  }

  public User getUserByEmail(String email) {
    return repository.findByEmail(email).orElse(null);
  }
}
