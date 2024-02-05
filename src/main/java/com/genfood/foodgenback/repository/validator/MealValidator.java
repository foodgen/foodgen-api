package com.genfood.foodgenback.repository.validator;

import com.genfood.foodgenback.repository.MealRepository;
import com.genfood.foodgenback.repository.model.Meal;
import com.genfood.foodgenback.repository.model.exception.BadRequestException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MealValidator implements Consumer<Meal> {

  private final MealRepository mealRepository;

  public void accept(List<Meal> meals) {
    meals.forEach(this::accept);
  }

  @Override
  public void accept(Meal meal) {
    Set<String> violationMessages = new HashSet<>();
    if (meal.getName() == null) {
      violationMessages.add("Name is mandatory");
    }
    if (meal.getDownload() == null) {
      violationMessages.add("Download is mandatory");
    }
    if (meal.getImage() == null) {
      violationMessages.add("Image is mandatory");
    }
    if (meal.getRecipe() == null) {
      violationMessages.add("Recipe is mandatory");
    }
    if (meal.getRegion() == null) {
      violationMessages.add("Region is mandatory");
    }
    if (mealRepository.existsByName(meal.getName())) {
      violationMessages.add("This meal already exists.");
    }
    if (!violationMessages.isEmpty()) {
      String formattedViolationMessages =
          violationMessages.stream().map(String::toString).collect(Collectors.joining(""));
      throw new BadRequestException(formattedViolationMessages);
    }
  }
}
