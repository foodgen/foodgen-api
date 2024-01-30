package com.genfood.foodgenback.controller;

import com.genfood.foodgenback.model.Ingredients;
import com.genfood.foodgenback.service.IngredientService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class IngredientController {
  private final IngredientService ingredientService;

  @GetMapping("/ingredient/{id}")
  public Ingredients getIngredientById(@PathVariable String id) {
    return ingredientService.getById(id);
  }

  @PutMapping("/ingredients")
  public List<Ingredients> putRecipe(@RequestBody List<Ingredients> ingredientsList) {
    return ingredientService.saveIngredients(ingredientsList);
  }

  @GetMapping("/ingredients")
  public List<Ingredients> getAll() {
    return ingredientService.getAll();
  }
}
