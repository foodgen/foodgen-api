package com.genfood.foodgenback.endpoint.rest.controller.validator;


import com.genfood.foodgenback.model.User;
import com.genfood.foodgenback.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MailValidator implements Consumer <User>{
    private  final UserRepository userRepository;
    @Override
    public void accept(User user) {
        boolean alreadyexist = userRepository.existsByEmail(user.getEmail());
        Set<String> violationMessages = new HashSet<>();
        if (alreadyexist) {
            violationMessages.add("Mail address already taken,try other");
        }
        if (!violationMessages.isEmpty()) {
            String formattedViolationMessages = violationMessages.stream()
                    .map(String::toString)
                    .collect(Collectors.joining(""));
            throw new RuntimeException(formattedViolationMessages);
        }
    }
}

