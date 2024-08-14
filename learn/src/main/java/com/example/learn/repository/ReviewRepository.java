package com.example.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.learn.model.ReviewModel;

import jakarta.transaction.Transactional;

public interface ReviewRepository extends JpaRepository<ReviewModel,Integer>{


    List<ReviewModel> findByEmail(String email);


  @Transactional
  @Modifying
  @Query("Update ReviewModel r set answer=?2 where id=?1")
  public void setanswer(int id,String answer);

















    
}
