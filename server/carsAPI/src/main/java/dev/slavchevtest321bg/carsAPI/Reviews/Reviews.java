package dev.slavchevtest321bg.carsAPI.Reviews;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="reviews")

public class Reviews {
    @Id
    private ObjectId id;

    private String body;

    public Reviews(String body) {
        this.body = body;
    }
}
