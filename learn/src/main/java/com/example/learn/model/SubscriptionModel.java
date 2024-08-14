package com.example.learn.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SubscriptionModel {

    @Id
    private int id;
    private String name;
    private String details;
    private String subtype;

    private List<Integer> users;


    
}
