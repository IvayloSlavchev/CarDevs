package dev.slavchevtest321bg.carsAPI.Cars;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarsRepository extends MongoRepository<Cars, ObjectId> {
    Optional<Cars> findCarById(String id);
}
