package com.genfood.foodgenback.endpoint.rest.mapper;

import com.genfood.foodgenback.endpoint.rest.model.Recipe;
import com.genfood.foodgenback.repository.model.RecipeIngredient;
import com.genfood.foodgenback.service.RecipeIngredientService;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RecipeMapper {
  private RecipeIngredientService recipeIngredientService;
  private RecipeIngredientMapper recipeIngredientMapper;

  public Recipe toDto(com.genfood.foodgenback.repository.model.Recipe entity) {
    List<RecipeIngredient> recipesIngredients =
        recipeIngredientService.getAllByRecipeId(entity.getId());
    List<com.genfood.foodgenback.endpoint.rest.model.RecipeIngredient> restRecipeIngredients =
        recipesIngredients.stream().map(recipeIngredientMapper::toDto).toList();
    return Recipe.builder()
        .id(entity.getId())
        .name(entity.getName())
        .readme(entity.getReadme())
        .ingredients(restRecipeIngredients)
        .build();
  }

  public com.genfood.foodgenback.repository.model.Recipe toEntity(Recipe dto) {
    if (Objects.nonNull(dto.getIngredients())) {
      dto.getIngredients()
          .forEach(
              (dtoRecipeIngredient) -> {
                if (Objects.isNull(
                    recipeIngredientService.findByRecipeIdAndIngredientName(
                        dto.getId(), dtoRecipeIngredient.getIngredientName()))) {
                  recipeIngredientService.save(
                      recipeIngredientMapper.toEntity(dtoRecipeIngredient, dto.getId()));
                }
              });
    }
    return com.genfood.foodgenback.repository.model.Recipe.builder()
        .id(dto.getId())
        .name(dto.getName())
        .readme(dto.getReadme())
        .build();
  }
}
