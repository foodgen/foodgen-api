package com.genfood.foodgenback.service;

import com.genfood.foodgenback.repository.RecipeIngredientRepository;
import com.genfood.foodgenback.repository.model.RecipeIngredient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeIngredientService {
    private final RecipeIngredientRepository repository;

    public List<RecipeIngredient> getAllByRecipeId(String id) {
        return repository.findAllByRecipe_Id(id);
    }
}
