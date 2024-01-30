package com.genfood.foodgenback.controller;

import com.genfood.foodgenback.model.Recipe;
import com.genfood.foodgenback.service.RecipeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class RecipeController {
  private final RecipeService recipeService;

  @GetMapping("/recipe/{id}")
  public Recipe getRecipeById(@PathVariable String id) {
    return recipeService.getById(id);
  }

  @PutMapping("/recipes")
  public List<Recipe> putRecipe(@RequestBody List<Recipe> recipes) {
    return recipeService.saveAll(recipes);
  }

  @GetMapping("/recipes")
  public List<Recipe> getRecipes() {
    return recipeService.getAll();
  }
}
