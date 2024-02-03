package com.genfood.foodgenback.service;

import com.genfood.foodgenback.repository.AllergyRepository;
import com.genfood.foodgenback.repository.model.Allergy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AllergyService {
    private final AllergyRepository allergyRepository;

    public List<Allergy> getAllergies(){
        return allergyRepository.findAll();
    }
}
