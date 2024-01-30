package com.genfood.foodgenback.endpoint.controller;

import com.genfood.foodgenback.endpoint.rest.mapper.IngredientMapper;
import com.genfood.foodgenback.endpoint.rest.model.Ingredients;
import com.genfood.foodgenback.endpoint.rest.model.Region;
import com.genfood.foodgenback.service.IngredientService;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class IngredientController {
  private final IngredientService ingredientService;
  private final IngredientMapper ingredientMapper;

  @GetMapping("/ingredients")
  public List<Ingredients> getIngredients(
          @RequestParam("page") Integer page, @RequestParam("page_size") Integer pageSize) {
    List<Ingredients> ingredients =
            ingredientService.getIngredients(page, pageSize).stream()
                    .map(ingredientMapper::toDto)
                    .collect(Collectors.toUnmodifiableList());
    return ingredients;
  }
  @GetMapping("/ingredients/{id}")
  public Ingredients getIngredientById(@PathVariable String id) {
    Ingredients ingredients = ingredientMapper.toDto(ingredientService.getById(id));
    return ingredients;
  }

  @PutMapping("/ingredients")
  public List<Ingredients> crupdateRecipe(@RequestBody List<Ingredients> ingredients) {
    List<com.genfood.foodgenback.repository.model.Ingredients> toSave =
            ingredients.stream().map(ingredientMapper::toEntity).collect(Collectors.toUnmodifiableList());
    List<Ingredients> crupdated =
            ingredientService.saveIngredients(toSave).stream()
                    .map(ingredientMapper::toDto)
                    .collect(Collectors.toUnmodifiableList());
    return crupdated;
  }
}
