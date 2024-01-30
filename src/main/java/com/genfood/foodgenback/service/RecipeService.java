package com.genfood.foodgenback.service;

import com.genfood.foodgenback.repository.RecipeIngredientRepository;
import com.genfood.foodgenback.repository.model.Recipe;
import com.genfood.foodgenback.repository.RecipeRepository;
import java.util.List;

import com.genfood.foodgenback.repository.model.RecipeIngredient;
import com.genfood.foodgenback.repository.model.Region;
import com.genfood.foodgenback.repository.validator.RecipeValidator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeService {
  private final RecipeRepository recipeRepository;
  private final RecipeValidator recipeValidator;
  private final RecipeIngredientRepository repository;

  public List<Recipe> getRecipes(Integer page, Integer pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize);
    return recipeRepository.findAll(pageable).toList();
  }

  public List<Recipe> saveRecipes(List<Recipe> recipes) {
    recipeValidator.accept(recipes);
    return recipeRepository.saveAll(recipes);
  }
}
