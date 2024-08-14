package com.example.learn.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.learn.model.ReviewModel;
import com.example.learn.service.ReviewService;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/review")
@CrossOrigin 
public class ReviewController {


     @Autowired
    private ReviewService reviewService;


    @PostMapping("/posting")
    public ResponseEntity<ReviewModel> createReview(@RequestBody ReviewModel review) {
        ReviewModel savedReview = reviewService.createReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @GetMapping("/getting")
    public List<ReviewModel> getAllReviews() {
        return reviewService.getAllReviews();
    }


    @GetMapping("/getbyemail/{email}")
    public List<ReviewModel> getReviewById(@PathVariable String email) {
         return reviewService.getReviewByEmail(email);
       
    }
    
    @DeleteMapping("delete/{id}")
    public String deleteReview(@PathVariable int id) {
        try {
            reviewService.deleteReview(id);
            return "deleted";
        } catch (RuntimeException e) {
            return "id not found";
        }
    }

    @PutMapping("/reviewanswer")
    public void putMethodName(@RequestBody ReviewModel answer){
       reviewService.setanswer(answer.getId(),answer.getAnswer());
        
        
    }
    
}
