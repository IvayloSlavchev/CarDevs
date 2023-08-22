package dev.slavchevtest321bg.carsAPI.Cars;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cars")
public class CarsController {
    @Autowired
    private CarsService carsService;

    @GetMapping
    public ResponseEntity<List<Cars>> getAllCars() {
        return new ResponseEntity<List<Cars>>(carsService.allCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cars>> getSingleCar(@PathVariable String id) {
        return new ResponseEntity<Optional<Cars>>(carsService.signleCar(id), HttpStatus.OK);
    }
}
