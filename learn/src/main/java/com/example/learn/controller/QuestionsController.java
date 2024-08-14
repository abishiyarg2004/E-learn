package com.example.learn.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.learn.model.Questionsmodel;
import com.example.learn.service.QuestionsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionsController {


    @Autowired
    public QuestionsService questionsService;

    @GetMapping("/getting")
    public List<Questionsmodel> getting() {
        return questionsService.getting();
    }
    

    @PostMapping("/putting")
    public String putting(@RequestBody Questionsmodel question) {
       
        
        return questionsService.posting(question);
    }

    @DeleteMapping("/deleting/{id}")
    public String deleting(@PathVariable int id) {
        return questionsService.deleting(id);
    }
    
    @GetMapping("/getbycourseid/{id}")
    public List<Questionsmodel> getbycourseid(@PathVariable int id) {
        return questionsService.getbycourseid(id);
    }
    
    
}
