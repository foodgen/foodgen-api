package com.genfood.foodgenback.service;

import com.genfood.foodgenback.model.Ingredients;
import com.genfood.foodgenback.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public Ingredients getById(String id){
        return ingredientRepository.findById(id).get();
    }

    public List<Ingredients> saveIngredients(List<Ingredients> ingredientsList){
        return ingredientRepository.saveAll(ingredientsList);
    }

    public List<Ingredients> getAll(){
        return ingredientRepository.findAll();
    }
}
