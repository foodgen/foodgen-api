package com.genfood.foodgenback.service;

import com.genfood.foodgenback.repository.model.Ingredients;
import com.genfood.foodgenback.repository.IngredientRepository;
import java.util.List;

import com.genfood.foodgenback.repository.model.Recipe;
import com.genfood.foodgenback.repository.validator.IngredientValidator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IngredientService {
  private final IngredientRepository ingredientRepository;
  private final IngredientValidator ingredientValidator;
  public List<Ingredients> getIngredients(Integer page, Integer pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize);
    return ingredientRepository.findAll(pageable).toList();
  }
  public Ingredients getById(String id) {
    return ingredientRepository.findById(id).orElseThrow();
  }

  public List<Ingredients> saveIngredients(List<Ingredients> ingredientsList) {
    ingredientValidator.accept(ingredientsList);
    return ingredientRepository.saveAll(ingredientsList);
  }

}
