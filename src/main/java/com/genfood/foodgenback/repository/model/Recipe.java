package com.genfood.foodgenback.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "\"recipe\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Recipe {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String readme;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipe recipe = (Recipe) o;
    return Objects.equals(name, recipe.name) && Objects.equals(readme, recipe.readme);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, readme);
  }
}
