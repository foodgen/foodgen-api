package com.genfood.foodgenback.endpoint.controller;

import com.genfood.foodgenback.endpoint.rest.mapper.AllergyMapper;
import com.genfood.foodgenback.endpoint.rest.model.Allergy;
import com.genfood.foodgenback.service.AllergyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class AllergyController {
    private final AllergyService allergyService;
    private final AllergyMapper allergyMapper;

    @GetMapping("/allergy")
    public List<Allergy> getAllergies(){
        return allergyService.getAllergies().stream()
                .map(allergyMapper::toDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
