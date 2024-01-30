package com.genfood.foodgenback.endpoint.rest.mapper;

import com.genfood.foodgenback.endpoint.rest.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {
    public Recipe toDto(com.genfood.foodgenback.repository.model.Recipe entity) {
        return Recipe.builder().id(entity.getId()).name(entity.getName()).readme(entity.getReadme()).build();
    }

    public com.genfood.foodgenback.repository.model.Recipe toEntity(Recipe dto) {
        return com.genfood.foodgenback.repository.model.Recipe.builder()
                .id(dto.getId())
                .name(dto.getName())
                .readme(dto.getReadme())
                .build();
    }
}
