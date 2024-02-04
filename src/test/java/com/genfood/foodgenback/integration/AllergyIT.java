package com.genfood.foodgenback.integration;

import com.genfood.foodgenback.conf.FacadeIT;
import com.genfood.foodgenback.endpoint.controller.AllergyController;
import com.genfood.foodgenback.endpoint.rest.mapper.AllergyMapper;
import com.genfood.foodgenback.endpoint.rest.model.Allergy;
import com.genfood.foodgenback.repository.AllergyRepository;
import com.genfood.foodgenback.repository.UserRepository;
import com.genfood.foodgenback.service.AllergyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static com.genfood.foodgenback.utils.AllergyUtils.*;
import static com.genfood.foodgenback.utils.UserUtils.USER1_ID;

@Testcontainers
@Slf4j
public class AllergyIT extends FacadeIT {
    AllergyController allergyController;
    AllergyService allergyService;
    @Autowired
    AllergyMapper allergyMapper;
    @Autowired
    AllergyRepository allergyRepository;
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        allergyService = new AllergyService(allergyRepository,userRepository);
        allergyController = new AllergyController(allergyService,allergyMapper);
    }

    @Test
    void read_allergies() {
        int expected = 3;
        List<Allergy> actual = allergyController.getAllergies();
        Assertions.assertTrue(actual.contains(allergy1()));
        Assertions.assertTrue(actual.contains(allergy2()));
        Assertions.assertEquals(actual, List.of(allergy1(),allergy2(),allergy3()));
        Assertions.assertEquals(expected, actual.size());
    }

    @Test
    void read_allergy_by_user_id()  {
        List<Allergy> actual = allergyController.findAllergyByUserId(USER1_ID);
        List<Allergy> expected = List.of(allergy1());
        Assertions.assertEquals(expected, actual);
    }
}
