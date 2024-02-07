package com.genfood.foodgenback.endpoint.controller;

import com.genfood.foodgenback.endpoint.rest.mapper.RecipeIngredientMapper;
import com.genfood.foodgenback.endpoint.rest.mapper.RecipeMapper;
import com.genfood.foodgenback.endpoint.rest.model.Recipe;
import com.genfood.foodgenback.endpoint.rest.model.RecipeIngredients;
import com.genfood.foodgenback.service.RecipeIngredientService;
import com.genfood.foodgenback.service.RecipeService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RecipeController {
  private final RecipeService recipeService;
  private final RecipeMapper recipeMapper;
  private final RecipeIngredientMapper recipeIngredientMapper;
  private final RecipeIngredientService recipeIngredientService;

  @GetMapping("/recipes")
  public List<Recipe> getRecipes(
      @RequestParam("page") Integer page, @RequestParam("page_size") Integer pageSize) {
    List<Recipe> recipes =
        recipeService.getRecipes(page, pageSize).stream()
            .map(recipeMapper::toDto)
            .collect(Collectors.toUnmodifiableList());
    return recipes;
  }

  @GetMapping("/recipe/{id}")
  public RecipeIngredients getRecipeById(@PathVariable String id) {
    RecipeIngredients recipe =
        recipeIngredientMapper.toDto(recipeIngredientService.getAllByRecipeId(id));
    return recipe;
  }

  @PutMapping("/recipes")
  public List<Recipe> crupdateRecipes(@RequestBody List<Recipe> recipes) {
    List<com.genfood.foodgenback.repository.model.Recipe> toSave =
        recipes.stream().map(recipeMapper::toEntity).collect(Collectors.toUnmodifiableList());
    List<Recipe> updatedRecipes =
        recipeService.saveRecipes(toSave).stream()
            .map(recipeMapper::toDto)
            .collect(Collectors.toUnmodifiableList());
    return updatedRecipes;
  }
}
