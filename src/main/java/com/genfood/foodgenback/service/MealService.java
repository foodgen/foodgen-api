package com.genfood.foodgenback.service;

import com.genfood.foodgenback.endpoint.rest.mapper.RecipeIngredientMapper;
import com.genfood.foodgenback.endpoint.rest.model.Ingredients;
import com.genfood.foodgenback.repository.MealRepository;
import com.genfood.foodgenback.repository.model.Allergy;
import com.genfood.foodgenback.repository.model.Meal;
import com.genfood.foodgenback.repository.model.User;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MealService {

  private final MealRepository mealRepository;
  private final RecipeIngredientService recipeIngredientService;
  private final AuthService service;
  private final AllergyService allergyService;
  private final RecipeIngredientMapper recipeIngredientMapper;

  public Meal getMealById(String id) {
    return mealRepository.findById(id).get();
  }

  public List<Meal> getMealByRating(Integer page, Integer pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize);
    return mealRepository.findAllOrderByDownload(pageable);
  }

  public List<Meal> getRandomMeals(HttpServletRequest request) {
    User user = service.whoami(request);
    List<Allergy> allergies = allergyService.findAllergyByUserId(user.getId());
    List<Meal> meals = new ArrayList<>();
    if (allergies.size() == 0) {
      meals.add(mealRepository.findMealRandomly());
      meals.add(mealRepository.findMealRandomly());
      meals.add(mealRepository.findMealRandomly());
    } else {
      while (meals.size() < 3) {
        boolean badIngredient = false;
        Meal meal = mealRepository.findMealRandomly();
        List<Ingredients> mealIngredients =
            recipeIngredientMapper
                .toDto(recipeIngredientService.getAllByRecipeId(meal.getRecipe().getId()))
                .getIngredients();
        for (Allergy allergy : allergies) {
          for (int i = 0; i < mealIngredients.size(); i++) {
            if (allergy.getIngredient().equals(mealIngredients.get(i))) {
              badIngredient = true;
            }
          }
        }
        if (badIngredient) {
          meals.add(meal);
        } else {
          badIngredient = false;
        }
      }
    }
    return meals;
  }
}
