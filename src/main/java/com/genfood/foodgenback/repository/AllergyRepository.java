package com.genfood.foodgenback.repository;

import com.genfood.foodgenback.repository.model.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, String> {
}
