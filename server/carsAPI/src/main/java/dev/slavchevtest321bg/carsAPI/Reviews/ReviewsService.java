package dev.slavchevtest321bg.carsAPI.Reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.slavchevtest321bg.carsAPI.Cars.Cars;

@Service
public class ReviewsService {
    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired 
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String reviewBody, String id) {
        Reviews reviews = reviewsRepository.insert(new Reviews(reviewBody));
        
        mongoTemplate.update(Cars.class)
            .matching(Criteria.where("id").is(id))
                .apply(new Update().push("reviews").value(reviews))
                    .first();

        return reviews;
    }
}
