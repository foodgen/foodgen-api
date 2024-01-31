package com.genfood.foodgenback.utils;

import com.genfood.foodgenback.endpoint.rest.model.Recipe;
import com.genfood.foodgenback.endpoint.rest.model.RecipeIngredients;

import java.util.List;

import static com.genfood.foodgenback.utils.IngredientUtils.ig1;

public class RecipeUtils {
  public static final String RECIPE1_ID = "recipe1_id";
  public static final String RECIPE2_ID = "recipe2_id";
  public static final String RECIPE3_ID = "recipe3_id";
  public static final String RECIPE1_NAME = "recipe1_name";
  public static final String RECIPE2_NAME = "recipe2_name";
  public static final String RECIPE3_NAME = "recipe3_name";
  public static final String UPDATED_RECIPE3_NAME = "rcp3_name";
  public static final String RECIPE1_README = "recipe1_readme";
  public static final String RECIPE2_README = "recipe2_readme";
  public static final String RECIPE3_README = "recipe3_readme";

  public static Recipe recipe1() {
    return Recipe.builder().id(RECIPE1_ID).name(RECIPE1_NAME).readme(RECIPE1_README).build();
  }
  public static RecipeIngredients recipeIngredients1() {
    return RecipeIngredients.builder()
            .recipe(recipe1())
            .ingredients(List.of(ig1()))
            .build();
  }

  public static Recipe recipe2() {
    return Recipe.builder().id(RECIPE2_ID).name(RECIPE2_NAME).readme(RECIPE2_README).build();
  }

  public static Recipe recipe3() {
    return Recipe.builder().id(RECIPE3_ID).name(RECIPE3_NAME).readme(RECIPE3_README).build();
  }

  public static Recipe updatedRecipe3() {
    return Recipe.builder().id(RECIPE3_ID).name(UPDATED_RECIPE3_NAME).readme(RECIPE3_README).build();
  }
}
