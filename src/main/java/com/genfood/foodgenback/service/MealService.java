package com.genfood.foodgenback.service;

import com.genfood.foodgenback.repository.MealRepository;
import com.genfood.foodgenback.repository.model.Meal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MealService {

  private final MealRepository mealRepository;

  public Meal getMealById(String id) {
    return mealRepository.findById(id).get();
  }

  public List<Meal> getRandomMeals() {
    List<Meal> meals = mealRepository.findMealRandomly();
    return meals;
  }
}
