package com.example.learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class VideoModel {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

     private String title;
      private String description;
      private String url;
      private String publishedDate;
      private int courseId;

}
