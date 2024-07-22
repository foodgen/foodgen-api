package com.genfood.foodgenback.endpoint.rest.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Recipe {
  private String id;
  private String name;
  private String readme;
  private List<RecipeIngredient> ingredients;
}
