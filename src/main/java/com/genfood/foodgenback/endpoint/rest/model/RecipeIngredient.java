package com.genfood.foodgenback.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RecipeIngredient {
  private String id;
  private String ingredientName;
  private String measure;
}
