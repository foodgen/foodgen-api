package com.genfood.foodgenback.repository;

import com.genfood.foodgenback.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, String> {
  User findByUsername(String name);

  User getById(String id);

  Optional<User> findByEmail(String email);

  boolean existsByEmail(String email);
}
