package dev.slavchevtest321bg.carsAPI.Cars;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import dev.slavchevtest321bg.carsAPI.Reviews.Reviews;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="cars")

public class Cars {
    @Id
    private String id;
    private String brand;
    private String model;
    private int price;
    private List<String> engineTypes;
    private String image;
    private List<Integer> horsePower;

    @DocumentReference
    private List<Reviews> reviews;
}
