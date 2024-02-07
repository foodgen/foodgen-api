package com.genfood.foodgenback.repository;

import com.genfood.foodgenback.repository.model.Ingredients;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredients, String> {
  boolean existsByName(String name);

  List<Ingredients> findAllByNameIsContainingIgnoreCase(String name);
}
