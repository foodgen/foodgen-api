package com.genfood.foodgenback.endpoint.controller;

import com.genfood.foodgenback.endpoint.rest.mapper.MealMapper;
import com.genfood.foodgenback.endpoint.rest.model.Ingredients;
import com.genfood.foodgenback.endpoint.rest.model.Meal;
import com.genfood.foodgenback.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MealController {
    private final MealService mealService;
    private final MealMapper mealMapper;

    @GetMapping("/meals")
    public List<Meal> getMeals() {
        List<Meal> meals =
                mealService.getRandomMeals().stream()
                        .map(mealMapper::toDto)
                        .collect(Collectors.toUnmodifiableList());
        return meals;
    }

    @GetMapping("/meals/{id}")
    public Meal getMeals(@PathVariable String id) {
        return mealMapper.toDto(mealService.getMealById(id));
    }

}
