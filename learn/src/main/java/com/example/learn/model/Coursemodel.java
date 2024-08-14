package com.example.learn.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Coursemodel {
    
    @Id
    private int id;
    private boolean enrolled;
    private String title;
    private String description;
    private String image;
    private String authorName;
    private String authorRole;
    private String duration;
    private String level;
    private String price;
    private String provider;
    private String expiresOn;
    private String language;
    private String quizDuration;

   
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "coursemodel")
    private List<Questionsmodel> questions;




}
