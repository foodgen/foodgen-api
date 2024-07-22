package com.genfood.foodgenback.repository.validator;

import com.genfood.foodgenback.repository.RecipeRepository;
import com.genfood.foodgenback.repository.model.Recipe;
import com.genfood.foodgenback.repository.model.exception.BadRequestException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RecipeValidator implements Consumer<Recipe> {
  private final RecipeRepository recipeRepository;

  public void accept(List<Recipe> recipes) {
    recipes.forEach(this::accept);
  }

  @Override
  public void accept(Recipe recipe) {
    Set<String> violationMessages = new HashSet<>();
    Recipe queriedRecipe = recipeRepository.findByName(recipe.getName());

    if (recipe.getName() == null) {
      violationMessages.add("Name is mandatory");
    }
    if (recipe.getReadme() == null) {
      violationMessages.add("Readme is mandatory");
    }
    if ((Objects.nonNull(queriedRecipe) && Objects.equals(queriedRecipe, recipe))
        || (Objects.nonNull(queriedRecipe) && queriedRecipe.equals(recipe))) {
      violationMessages.add("This recipe already exists.");
    }
    if (!violationMessages.isEmpty()) {
      String formattedViolationMessages =
          violationMessages.stream().map(String::toString).collect(Collectors.joining("\n"));
      throw new BadRequestException(formattedViolationMessages);
    }
  }
}
