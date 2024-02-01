package com.genfood.foodgenback.utils;

import com.genfood.foodgenback.endpoint.rest.model.Meal;
import static com.genfood.foodgenback.utils.RecipeUtils.recipe1;
import static com.genfood.foodgenback.utils.RecipeUtils.recipe2;
import static com.genfood.foodgenback.utils.RecipeUtils.recipe3;
import static com.genfood.foodgenback.utils.RegionUtils.region1;
import static com.genfood.foodgenback.utils.RegionUtils.region2;
import static com.genfood.foodgenback.utils.RegionUtils.region3;

public class MealUtils {

    public static final String MEAL1_ID = "meal1_id";
    public static final String MEAL2_ID = "meal2_id";
    public static final String MEAL3_ID = "meal3_id";
    public static final String MEAL1_NAME = "meal1_name";
    public static final String MEAL2_NAME = "meal2_name";
    public static final String MEAL3_NAME = "meal3_name";
    public static final String UPDATED_MEAL3_NAME = "ml3_name";
    public static final Integer MEAL1_DOWNLOAD = 10;
    public static final Integer MEAL2_DOWNLOAD = 5;
    public static final Integer MEAL3_DOWNLOAD = 1;


    public static Meal meal1() {
        return Meal.builder()
                .id(MEAL1_ID)
                .name(MEAL1_NAME)
                .image(null)
                .download(MEAL1_DOWNLOAD)
                .region(region1())
                .recipe(recipe1())
                .build(); }
    public static Meal meal2() {
        return Meal.builder()
                .id(MEAL2_ID)
                .name(MEAL2_NAME)
                .image(null)
                .download(MEAL2_DOWNLOAD)
                .region(region2())
                .recipe(recipe2())
                .build(); }
    public static Meal meal3() {
        return Meal.builder()
                .id(MEAL3_ID)
                .name(MEAL3_NAME)
                .image(null)
                .download(MEAL3_DOWNLOAD)
                .region(region3())
                .recipe(recipe3())
                .build(); }
    public static Meal updatedMeal3() {
        return Meal.builder()
                .id(MEAL3_ID)
                .name(UPDATED_MEAL3_NAME)
                .image(null)
                .download(MEAL3_DOWNLOAD)
                .region(region3())
                .recipe(recipe3())
                .build(); }
}
