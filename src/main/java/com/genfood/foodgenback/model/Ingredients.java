package com.genfood.foodgenback.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "\"recipe\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String name;
}
