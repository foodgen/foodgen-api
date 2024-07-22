package com.genfood.foodgenback.endpoint.rest.mapper;

import com.genfood.foodgenback.repository.model.Ingredient;
import com.genfood.foodgenback.repository.model.RecipeIngredient;
import com.genfood.foodgenback.service.IngredientService;
import com.genfood.foodgenback.service.RecipeService;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RecipeIngredientMapper {
  private IngredientService ingredientService;
  private RecipeService recipeService;

  public com.genfood.foodgenback.endpoint.rest.model.RecipeIngredient toDto(
      RecipeIngredient entity) {
    return com.genfood.foodgenback.endpoint.rest.model.RecipeIngredient.builder()
        .id(entity.getId())
        .ingredientName(
            Objects.nonNull(entity.getIngredient()) ? entity.getIngredient().getName() : null)
        .measure(entity.getMeasure())
        .build();
  }

  public RecipeIngredient toEntity(
      com.genfood.foodgenback.endpoint.rest.model.RecipeIngredient dto, String recipeId) {
    Ingredient ingredient = ingredientService.getIngredientByName(dto.getIngredientName());
    if (Objects.isNull(ingredient)) {
      ingredientService.saveIngredients(
          List.of(Ingredient.builder().name(dto.getIngredientName()).build()));
    }
    return RecipeIngredient.builder()
        .ingredient(ingredientService.getIngredientByName(dto.getIngredientName()))
        .recipe(recipeService.getRecipeById(recipeId))
        .build();
  }
}
