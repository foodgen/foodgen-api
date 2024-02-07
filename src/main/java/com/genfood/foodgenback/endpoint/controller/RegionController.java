package com.genfood.foodgenback.endpoint.controller;

import com.genfood.foodgenback.endpoint.rest.mapper.RegionMapper;
import com.genfood.foodgenback.endpoint.rest.model.Region;
import com.genfood.foodgenback.service.RegionService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/regions")
@CrossOrigin(origins = "*")
public class RegionController {
  private final RegionService service;
  private final RegionMapper mapper;

  @GetMapping
  public List<Region> getRegions(
      @RequestParam("page") Integer page, @RequestParam("page_size") Integer pageSize) {
    List<Region> regions =
        service.getRegions(page, pageSize).stream()
            .map(mapper::toDto)
            .collect(Collectors.toUnmodifiableList());
    return regions;
  }

  @GetMapping("/{id}")
  public Region getRegionById(@PathVariable("id") String id) {
    Region region = mapper.toDto(service.getRegionById(id));
    return region;
  }

  @PutMapping
  public List<Region> crupdateRegions(@RequestBody List<Region> regions) {
    List<com.genfood.foodgenback.repository.model.Region> toSave =
        regions.stream().map(mapper::toEntity).collect(Collectors.toUnmodifiableList());
    List<Region> crupdated =
        service.crupdateRegions(toSave).stream()
            .map(mapper::toDto)
            .collect(Collectors.toUnmodifiableList());
    return crupdated;
  }

  @DeleteMapping("/{id}")
  public String removeRegion(@PathVariable("id") String id) {
    service.removeById(id);
    return "Region." + id + " successfully removed.";
  }
}
