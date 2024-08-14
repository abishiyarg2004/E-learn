package com.example.learn.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learn.model.ReviewModel;
import com.example.learn.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;




@Service
public class ReviewService {


     @Autowired
    private ReviewRepository reviewRepository;


    
    public ReviewModel createReview(ReviewModel review) {
        return reviewRepository.save(review);
    }

    
    public List<ReviewModel> getAllReviews() {
        return reviewRepository.findAll();
    }

   
    public List<ReviewModel> getReviewByEmail(String email) {
        return reviewRepository.findByEmail(email);
    }

   
    public ReviewModel updateReview(int id, ReviewModel review) {
        if (reviewRepository.existsById(id)) {
            review.setId(id);
            return reviewRepository.save(review);
        } else {
            throw new RuntimeException("Review not found with id: " + id);
        }
    }

    public void deleteReview(int id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
        } else {
            throw new RuntimeException("Review not found with id: " + id);
        }
    }
    public void setanswer(int id,String answer){
        reviewRepository.setanswer(id, answer);
        
    }
    
}
