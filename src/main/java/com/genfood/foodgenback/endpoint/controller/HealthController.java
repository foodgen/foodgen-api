package com.genfood.foodgenback.endpoint.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
  @GetMapping("/ping")
  public ResponseEntity<String> pong() {
    return new ResponseEntity<>("pong", OK);
  }
}
