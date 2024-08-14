package com.example.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learn.model.Questionsmodel;
import com.example.learn.repository.QuestionsRepo;

@Service
public class QuestionsService {


    @Autowired
    public QuestionsRepo questionsRepo;

    public List<Questionsmodel> getting(){
        return questionsRepo.findAll();

    }

    public String posting(Questionsmodel question){
        questionsRepo.save(question);
        return "question posted ";
    }

    public String deleting(int id){
        questionsRepo.deleteById(id);
        return "question deleted";
    }

    public List<Questionsmodel> getbycourseid(int id){
        return questionsRepo.findbycourseid(id);
    }
}
