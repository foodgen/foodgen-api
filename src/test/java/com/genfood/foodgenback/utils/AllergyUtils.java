package com.genfood.foodgenback.utils;

import com.genfood.foodgenback.endpoint.rest.model.Allergy;

import static com.genfood.foodgenback.utils.IngredientUtils.*;
import static com.genfood.foodgenback.utils.UserUtils.*;

public class AllergyUtils {
    public static final String ALLERGY1_ID = "allergy1_id";
    public static final String ALLERGY2_ID = "allergy2_id";
    public static final String ALLERGY3_ID = "allergy3_id";

    public static Allergy allergy1(){
        return Allergy.builder()
                .id(ALLERGY1_ID)
                .user(user1())
                .ingredients(ig1())
                .build();
    }

    public static Allergy allergy2(){
        return Allergy.builder()
                .id(ALLERGY2_ID)
                .user(user2())
                .ingredients(ig2())
                .build();
    }

    public static Allergy allergy3(){
        return Allergy.builder()
                .id(ALLERGY3_ID)
                .user(user3())
                .ingredients(ig3())
                .build();
    }
}
