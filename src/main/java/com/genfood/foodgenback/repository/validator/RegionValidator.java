package com.genfood.foodgenback.repository.validator;

import com.genfood.foodgenback.repository.RegionRepository;
import com.genfood.foodgenback.repository.model.Region;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.genfood.foodgenback.repository.model.exception.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegionValidator implements Consumer<Region> {
  private final RegionRepository repository;

  public void accept(List<Region> regions) {
    regions.forEach(this::accept);
  }

  @Override
  public void accept(Region region) {
    Set<String> violationMessages = new HashSet<>();
    if (region.getName() == null) {
      violationMessages.add("Name is mandatory");
    }
    if (repository.existsByName(region.getName())) {
      violationMessages.add("This region already exists.");
    }
    if (!violationMessages.isEmpty()) {
      String formattedViolationMessages =
          violationMessages.stream().map(String::toString).collect(Collectors.joining(""));
      throw new BadRequestException(formattedViolationMessages);
    }
  }
}
