package com.genfood.foodgenback.service;

import com.genfood.foodgenback.repository.AllergyRepository;
import com.genfood.foodgenback.repository.UserRepository;
import com.genfood.foodgenback.repository.model.Allergy;
import com.genfood.foodgenback.repository.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AllergyService {
    private final AllergyRepository allergyRepository;
    private final UserRepository userRepository;

    public List<Allergy> getAllergies(){
        return allergyRepository.findAll();
    }

    public List<Allergy> findAllergyByUserId(String userId){
        User user = userRepository.findById(userId).orElse(null);
        return allergyRepository.findByUser(user);
    }
}
