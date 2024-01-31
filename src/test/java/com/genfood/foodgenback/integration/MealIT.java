package com.genfood.foodgenback.integration;

import com.genfood.foodgenback.conf.FacadeIT;
import com.genfood.foodgenback.endpoint.controller.MealController;
import com.genfood.foodgenback.endpoint.rest.mapper.MealMapper;
import com.genfood.foodgenback.endpoint.rest.model.Meal;
import com.genfood.foodgenback.repository.MealRepository;
import com.genfood.foodgenback.service.MealService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.util.List;
import static com.genfood.foodgenback.utils.MealUtils.MEAL1_ID;
import static com.genfood.foodgenback.utils.MealUtils.meal1;


@Testcontainers
@Slf4j
public class MealIT extends FacadeIT {
    MealController mealController;
    MealService mealService;
    @Autowired
    MealMapper mealMapper;
    @Autowired
    MealRepository mealRepository;

    @BeforeEach
    void setUp() {
        mealService = new MealService(mealRepository);
        mealController = new MealController(mealService,mealMapper);
    }

    @Test
    void read_meals() {
        List<Meal> actual = mealController.getMeals();
        Assertions.assertEquals(3, actual.size());
    }

    @Test
    void read_meal_by_id() {
        Meal actual = mealController.getMealById(MEAL1_ID);
        Assertions.assertEquals(meal1(), actual);
    }

}

