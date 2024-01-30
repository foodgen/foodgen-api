package com.genfood.foodgenback.utils;

import com.genfood.foodgenback.endpoint.rest.model.Recipe;

public class RecipeUtils {
    public static final String RECIPE1_ID = "recipe1_id";
    public static final String RECIPE2_ID = "recipe2_id";
    public static final String RECIPE3_ID = "recipe3_id";
    public static final String RECIPE1_NAME = "recipe1_name";
    public static final String RECIPE2_NAME = "recipe2_name";
    public static final String RECIPE3_NAME = "recipe3_name";
    public static final String UPDATED_RECIPE3_NAME = "rcp3_name";

    public static Recipe recipe1() { return Recipe.builder().id(RECIPE1_ID).name(RECIPE1_NAME).build(); }
    public static Recipe recipe2() { return Recipe.builder().id(RECIPE2_ID).name(RECIPE2_NAME).build(); }
    public static Recipe recipe3() { return Recipe.builder().id(RECIPE3_ID).name(RECIPE3_NAME).build(); }
    public static Recipe updatedRecipe3() { return Recipe.builder().id(RECIPE3_ID).name(UPDATED_RECIPE3_NAME).build(); }
}
