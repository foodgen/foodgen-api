package com.genfood.foodgenback.endpoint.rest.mapper;

import com.genfood.foodgenback.endpoint.rest.model.Ingredients;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {
  public Ingredients toDto(com.genfood.foodgenback.repository.model.Ingredients entity) {
    return Ingredients.builder().id(entity.getId()).name(entity.getName()).build();
  }

  public com.genfood.foodgenback.repository.model.Ingredients toEntity(Ingredients dto) {
    return com.genfood.foodgenback.repository.model.Ingredients.builder()
        .id(dto.getId())
        .name(dto.getName())
        .build();
  }
}
