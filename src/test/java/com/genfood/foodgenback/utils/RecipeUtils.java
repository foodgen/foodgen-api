package com.genfood.foodgenback.utils;

import com.genfood.foodgenback.endpoint.rest.model.Recipe;
import java.util.List;

public class RecipeUtils {
  public static final String RECIPE1_ID = "recipe1_id";
  public static final String RECIPE2_ID = "recipe2_id";
  public static final String RECIPE3_ID = "recipe3_id";
  public static final String RECIPE4_ID = "recipe4_id";
  public static final String RECIPE5_ID = "recipe5_id";
  public static final String RECIPE6_ID = "recipe6_id";
  public static final String RECIPE7_ID = "recipe7_id";
  public static final String RECIPE8_ID = "recipe8_id";
  public static final String RECIPE9_ID = "recipe9_id";
  public static final String RECIPE1_NAME = "recipe1_name";
  public static final String RECIPE2_NAME = "recipe2_name";
  public static final String RECIPE3_NAME = "recipe3_name";
  public static final String RECIPE4_NAME = "recipe4_name";
  public static final String RECIPE5_NAME = "recipe5_name";
  public static final String RECIPE6_NAME = "recipe6_name";
  public static final String RECIPE7_NAME = "recipe7_name";
  public static final String RECIPE8_NAME = "recipe8_name";
  public static final String UPDATED_RECIPE8_NAME = "updated_recipe8_name";
  public static final String RECIPE9_NAME = "recipe9_name";
  public static final String UPDATED_RECIPE9_NAME = "updated_recipe9_name";
  public static final String UPDATED_RECIPE3_NAME = "rcp3_name";
  public static final String RECIPE1_README = "recipe1_readme";
  public static final String RECIPE2_README = "recipe2_readme";
  public static final String RECIPE3_README = "recipe3_readme";
  public static final String RECIPE4_README = "recipe4_readme";
  public static final String RECIPE5_README = "recipe5_readme";
  public static final String RECIPE6_README = "recipe6_readme";
  public static final String RECIPE7_README = "recipe7_readme";
  public static final String RECIPE8_README = "recipe8_readme";
  public static final String RECIPE9_README = "recipe9_readme";

  public static Recipe recipe1() {
    return Recipe.builder()
        .id(RECIPE1_ID)
        .name(RECIPE1_NAME)
        .readme(RECIPE1_README)
        .ingredients(
            List.of(
                RecipeIngredientUtils.recipeIngredient1(),
                RecipeIngredientUtils.recipeIngredient2()))
        .build();
  }

  public static Recipe recipe2() {
    return Recipe.builder()
        .id(RECIPE2_ID)
        .name(RECIPE2_NAME)
        .readme(RECIPE2_README)
        .ingredients(
            List.of(
                RecipeIngredientUtils.recipeIngredient3(),
                RecipeIngredientUtils.recipeIngredient4()))
        .build();
  }

  public static Recipe recipe3() {
    return Recipe.builder().id(RECIPE3_ID).name(RECIPE3_NAME).readme(RECIPE3_README).build();
  }

  public static Recipe recipe4() {
    return Recipe.builder().id(RECIPE4_ID).name(RECIPE4_NAME).readme(RECIPE4_README).build();
  }

  public static Recipe recipe5() {
    return Recipe.builder().id(RECIPE5_ID).name(RECIPE5_NAME).readme(RECIPE5_README).build();
  }

  public static Recipe recipe6() {
    return Recipe.builder()
        .id(RECIPE6_ID)
        .name(RECIPE6_NAME)
        .readme(RECIPE6_README)
        .ingredients(
            List.of(
                RecipeIngredientUtils.recipeIngredient11(),
                RecipeIngredientUtils.recipeIngredient12()))
        .build();
  }

  public static Recipe recipe7() {
    return Recipe.builder()
        .id(RECIPE7_ID)
        .name(RECIPE7_NAME)
        .readme(RECIPE7_README)
        .ingredients(
            List.of(
                RecipeIngredientUtils.recipeIngredient13(),
                RecipeIngredientUtils.recipeIngredient14()))
        .build();
  }

  public static Recipe updatedRecipe3() {
    return Recipe.builder()
        .id(RECIPE3_ID)
        .name(UPDATED_RECIPE3_NAME)
        .readme(RECIPE3_README)
        .ingredients(
            List.of(
                RecipeIngredientUtils.recipeIngredient5(),
                RecipeIngredientUtils.recipeIngredient6()))
        .build();
  }

  public static Recipe recipe8() {
    return Recipe.builder()
        .id(RECIPE8_ID)
        .name(RECIPE8_NAME)
        .readme(RECIPE8_README)
        .ingredients(
            List.of(
                RecipeIngredientUtils.recipeIngredient15(),
                RecipeIngredientUtils.recipeIngredient16()))
        .build();
  }

  public static Recipe updatedRecipe8() {
    return Recipe.builder()
        .id(RECIPE8_ID)
        .name(UPDATED_RECIPE8_NAME)
        .readme(RECIPE8_README)
        .ingredients(
            List.of(
                RecipeIngredientUtils.recipeIngredient15(),
                RecipeIngredientUtils.recipeIngredient16()))
        .build();
  }

  public static Recipe recipe9() {
    return Recipe.builder()
        .id(RECIPE9_ID)
        .name(RECIPE9_NAME)
        .readme(RECIPE9_README)
        .ingredients(
            List.of(
                RecipeIngredientUtils.recipeIngredient17(),
                RecipeIngredientUtils.recipeIngredient18()))
        .build();
  }

  public static Recipe updatedRecipe9() {
    return Recipe.builder()
        .id(RECIPE9_ID)
        .name(UPDATED_RECIPE9_NAME)
        .readme(RECIPE9_README)
        .ingredients(
            List.of(
                RecipeIngredientUtils.recipeIngredient17(),
                RecipeIngredientUtils.recipeIngredient18()))
        .build();
  }
}
