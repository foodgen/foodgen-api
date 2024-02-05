package com.genfood.foodgenback.integration;

import com.genfood.foodgenback.conf.FacadeIT;
import com.genfood.foodgenback.endpoint.controller.MealController;
import com.genfood.foodgenback.endpoint.rest.mapper.MealMapper;
import com.genfood.foodgenback.endpoint.rest.mapper.RecipeIngredientMapper;
import com.genfood.foodgenback.endpoint.rest.model.Meal;
import com.genfood.foodgenback.repository.MealRepository;
import com.genfood.foodgenback.service.AllergyService;
import com.genfood.foodgenback.service.AuthService;
import com.genfood.foodgenback.service.MealService;
import com.genfood.foodgenback.service.RecipeIngredientService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.util.List;
import static com.genfood.foodgenback.utils.MealUtils.MEAL1_ID;
import static com.genfood.foodgenback.utils.MealUtils.meal1;
import static com.genfood.foodgenback.utils.MealUtils.meal8;
import static com.genfood.foodgenback.utils.MealUtils.meal9;

@Testcontainers
@Slf4j
public class MealIT extends FacadeIT {
  public static final int PAGE = 0;
  public static final int PAGE_SIZE = 5;
  MealController mealController;
  MealService mealService;
  RecipeIngredientService recipeIngredientService;
  AuthService authService;
  AllergyService allergyService;

  HttpServletRequest request;

  @Autowired MealMapper mealMapper;
  @Autowired MealRepository mealRepository;
  @Autowired RecipeIngredientMapper recipeIngredientMapper;

  @BeforeEach
  void setUp() {
    mealService =
        new MealService(
            mealRepository,
            recipeIngredientService,
            authService,
            allergyService,
            recipeIngredientMapper);
    mealController = new MealController(mealService, mealMapper);
  }

  /*@Test
  void read_meals() {
    List<Meal> actual = mealController.getMeals(request);
    Assertions.assertTrue(actual.contains(meal1()));
    Assertions.assertTrue(actual.contains(meal2()));
    Assertions.assertTrue(actual.contains(meal3()));
    Assertions.assertEquals(3, actual.size());
  }*/
  @Test
  void read_meal_by_id() {
    Meal actual = mealController.getMealById(MEAL1_ID);
    Assertions.assertEquals(meal1(), actual);
  }

  @Test
  void read_meal_ordered() {
    List<Meal> actual = mealController.getMealsOrdered(PAGE,PAGE_SIZE);
    Assertions.assertEquals(5, actual.size());
    Assertions.assertEquals(actual.get(0), meal1());
    Assertions.assertEquals(actual.get(1), meal9());
    Assertions.assertEquals(actual.get(2), meal8());

  }

}
