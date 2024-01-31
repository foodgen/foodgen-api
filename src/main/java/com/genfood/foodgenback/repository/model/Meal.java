package com.genfood.foodgenback.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "\"meal\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class Meal {
  @Id private String id;

  @Column(nullable = false)
  private String name;

  @OneToOne
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  @OneToOne
  @JoinColumn(name = "region_id")
  private Region region;

  @Column(nullable = false)
  private String image;

  @Column(nullable = false)
  private Integer download;
}
