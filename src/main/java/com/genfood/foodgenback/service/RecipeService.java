package com.genfood.foodgenback.service;

import com.genfood.foodgenback.model.Recipe;
import com.genfood.foodgenback.repository.RecipeRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeService {
  private final RecipeRepository recipeRepository;

  public Recipe getById(String id) {
    return recipeRepository.findById(id).get();
  }

  public List<Recipe> saveAll(List<Recipe> recipes) {
    return recipeRepository.saveAll(recipes);
  }

  public List<Recipe> getAll() {
    return recipeRepository.findAll();
  }
}
