package com.genfood.foodgenback.repository;

import com.genfood.foodgenback.repository.model.Allergy;
import com.genfood.foodgenback.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, String> {
    List<Allergy> findByUser(User user);
}
