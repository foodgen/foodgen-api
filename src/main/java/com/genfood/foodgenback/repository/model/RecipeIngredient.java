package com.genfood.foodgenback.repository.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "\"recipe_ingredients\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class RecipeIngredient {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredients ingredient;
}
