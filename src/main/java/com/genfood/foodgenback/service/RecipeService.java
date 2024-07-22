package com.genfood.foodgenback.service;

import com.genfood.foodgenback.repository.RecipeRepository;
import com.genfood.foodgenback.repository.model.Recipe;
import com.genfood.foodgenback.repository.model.exception.NotFoundException;
import com.genfood.foodgenback.repository.validator.RecipeValidator;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeService {
  private final RecipeRepository recipeRepository;
  private final RecipeValidator recipeValidator;

  public List<Recipe> getRecipes(Integer page, Integer pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize);
    return recipeRepository.findAll(pageable).toList();
  }

  public List<Recipe> saveRecipes(List<Recipe> recipes) {
    recipeValidator.accept(recipes);
    return recipeRepository.saveAll(recipes);
  }

  public Recipe getRecipeById(String id) {
    return recipeRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Recipe of id:" + " " + id + " not found"));
  }

  public Recipe getById(String id) {
    return recipeRepository.getById(id);
  }
}
