package com.genfood.foodgenback.repository;

import com.genfood.foodgenback.repository.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, String> {
    List<RecipeIngredient> findAllByRecipe_Id(String id);
}
