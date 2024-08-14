package com.example.learn.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Questionsmodel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int ans;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Coursemodel coursemodel;


}
