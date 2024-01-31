package com.genfood.foodgenback.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Meal {
  private String id;
  private String name;
  private Recipe recipe;
  private Region region;
  private String image;
  private Integer download;
}
