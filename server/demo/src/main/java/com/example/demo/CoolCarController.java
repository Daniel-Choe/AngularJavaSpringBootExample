package com.okta.developer.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

// To enable CORS (Cross-Origin Resource Sharing)
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
class CoolCarController {
  private CarRepository repository;

  public CoolCarController(CarRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/cool-cars")

  // To enable CORS (Cross-Origin Resource Sharing)
  @CrossOrigin(origins = "http://localhost:4200")

  public Collection<Car> coolCars() {
    return repository.findAll().stream()
      .filter(this::isCool)
      .collect(Collectors.toList());
  }

  private boolean isCool(Car car) {
    return !car.getName().equals("Range Rover") &&
            !car.getName().equals("Ford") &&
            !car.getName().equals("GMC") &&
            !car.getName().equals("BMW") &&
            !car.getName().equals("Tesla") &&
            !car.getName().equals("Honda");
  }
}
