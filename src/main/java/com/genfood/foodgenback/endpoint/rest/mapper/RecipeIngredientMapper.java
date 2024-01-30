package com.genfood.foodgenback.endpoint.rest.mapper;

import com.genfood.foodgenback.endpoint.rest.model.RecipeIngredients;
import com.genfood.foodgenback.repository.model.Ingredients;
import com.genfood.foodgenback.repository.model.RecipeIngredient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeIngredientMapper {

    public RecipeIngredients toDto(List<RecipeIngredient> entity) {
        List<Ingredients> ingredients= new ArrayList<>();
        for (int i = 0 ; i <= entity.size(); i++) {
            ingredients.add(entity.get(i).getIngredient());
        }
        return RecipeIngredients.builder()
                .recipe_id(entity.get(0).getRecipe().getId())
                .ingredients(ingredients.size() > 0 ? ingredients : null)
                .build();
    }
}
