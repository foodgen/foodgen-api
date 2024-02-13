package com.genfood.foodgenback.service;

import com.genfood.foodgenback.repository.UserPreferencesRepository;
import com.genfood.foodgenback.repository.model.User;
import com.genfood.foodgenback.repository.model.UserPreference;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserPreferencesService {
    private final UserPreferencesRepository userPreferencesRepository;

    public List<UserPreference> saveAll(List<UserPreference> toCrupdate){
        return userPreferencesRepository.saveAll(toCrupdate);
    }

    public List<UserPreference> getPreferencesByUser(User user){
        return userPreferencesRepository.findAllByUser(user);
    }
}
