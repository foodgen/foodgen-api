package com.genfood.foodgenback.endpoint.rest.model;

import com.genfood.foodgenback.repository.model.Ingredients;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RecipeIngredients {
    private String recipe_id;
    private List<Ingredients> ingredients;
}
