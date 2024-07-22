package com.genfood.foodgenback.repository;

import com.genfood.foodgenback.repository.model.RecipeIngredient;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, String> {
  List<RecipeIngredient> findAllByRecipe_Id(String id);

  RecipeIngredient findByRecipe_IdAndIngredient_Name(String recipeId, String ingredientName);
}
