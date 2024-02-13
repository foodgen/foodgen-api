package com.genfood.foodgenback.repository;

import com.genfood.foodgenback.repository.model.User;
import com.genfood.foodgenback.repository.model.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPreferencesRepository extends JpaRepository<UserPreference,String> {
    List<UserPreference> findAllByUser(User user);
}
