package com.genfood.foodgenback.repository.validator;

import com.genfood.foodgenback.repository.IngredientRepository;
import com.genfood.foodgenback.repository.model.Ingredients;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class IngredientValidator implements Consumer<Ingredients> {
    private final IngredientRepository repository;

    public void accept(List<Ingredients> ingredients) {
        ingredients.forEach(this::accept);
    }

    @Override
    public void accept(Ingredients ingredients) {
        Set<String> violationMessages = new HashSet<>();
        if (ingredients.getName() == null) {
            violationMessages.add("Name is mandatory");
        }
        if (!violationMessages.isEmpty()) {
            String formattedViolationMessages =
                    violationMessages.stream().map(String::toString).collect(Collectors.joining(""));
            throw new RuntimeException(formattedViolationMessages);
        }
    }
}
