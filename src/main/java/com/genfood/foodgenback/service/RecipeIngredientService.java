package com.genfood.foodgenback.service;

import com.genfood.foodgenback.repository.RecipeIngredientRepository;
import com.genfood.foodgenback.repository.model.RecipeIngredient;
import com.genfood.foodgenback.repository.model.exception.NotFoundException;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeIngredientService {
  private final RecipeIngredientRepository repository;
  private final RecipeService recipeService;

  public List<RecipeIngredient> getAllByRecipeId(String id) {
    if (Objects.isNull(recipeService.getById(id))) {
      throw new NotFoundException("Recipe of id: " + id + " not found");
    } else {
      return repository.findAllByRecipe_Id(id);
    }
  }

  public List<RecipeIngredient> saveAll(List<RecipeIngredient> ingredients) {
    return repository.saveAll(ingredients);
  }

  public RecipeIngredient save(RecipeIngredient recipeIngredient) {
    return repository.save(recipeIngredient);
  }

  public RecipeIngredient findByRecipeIdAndIngredientName(String recipeId, String ingredientName) {
    return repository.findByRecipe_IdAndIngredient_Name(recipeId, ingredientName);
  }
}
