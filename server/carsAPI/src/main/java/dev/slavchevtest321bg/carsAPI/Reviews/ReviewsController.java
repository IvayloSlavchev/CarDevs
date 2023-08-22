package dev.slavchevtest321bg.carsAPI.Reviews;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;

    @PostMapping
    public ResponseEntity<Reviews> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Reviews>(reviewsService.createReview(payload.get("reviewBody"), payload.get("id")), HttpStatus.CREATED);
    }
}
