package com.example.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.learn.model.Questionsmodel;

public interface QuestionsRepo extends JpaRepository<Questionsmodel,Integer> {

    @Query(nativeQuery = true,value = "select * from questionsmodel where coursemodel_id=?1")
     List<Questionsmodel> findbycourseid(int id);

}
