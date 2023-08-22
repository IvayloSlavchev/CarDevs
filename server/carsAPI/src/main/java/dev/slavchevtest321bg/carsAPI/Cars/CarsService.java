package dev.slavchevtest321bg.carsAPI.Cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarsService {
    @Autowired
    private  CarsRepository carsRepository;

    public List<Cars> allCars() {
        return carsRepository.findAll();
    }

    public Optional<Cars> signleCar(String id) {
        return carsRepository.findCarById(id);
    }
}

