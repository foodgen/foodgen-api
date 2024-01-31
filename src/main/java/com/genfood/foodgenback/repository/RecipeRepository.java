package com.genfood.foodgenback.repository;

import com.genfood.foodgenback.repository.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {
  boolean existsByName(String name);
}
