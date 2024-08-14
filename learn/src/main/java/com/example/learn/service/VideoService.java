package com.example.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learn.model.VideoModel;
import com.example.learn.repository.VideoRepository;

@Service
public class VideoService {


    @Autowired
    public VideoRepository videoRepository;

    public List<VideoModel> getvideos(int courseid){
        return videoRepository.findByCourseId(courseid);
    }
    public void posting(VideoModel video){
        videoRepository.save(video);
    }

    public void deleting(int id){
        videoRepository.deleteById(id);
    }
}
