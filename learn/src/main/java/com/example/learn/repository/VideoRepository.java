package com.example.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learn.model.VideoModel;
import java.util.List;


public interface VideoRepository extends JpaRepository<VideoModel,Integer> {


    List<VideoModel> findByCourseId(int courseId);
}
