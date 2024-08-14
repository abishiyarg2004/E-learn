package com.example.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learn.model.VideoModel;
import com.example.learn.service.VideoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin
@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
   public VideoService videoService;


    @GetMapping("/getvideos/{id}")
    public List<VideoModel> getMethodName(@PathVariable int id) {
        return videoService.getvideos(id);
    }
    
    @PostMapping("/posting")
    public void postMethodName(@RequestBody List<VideoModel> video) {
        for(VideoModel v:video){
        videoService.posting(v);
        }
    }
    @DeleteMapping("/deleting/{id}")
    public void deleting(@PathVariable int id){
      videoService.deleting(id);
    }

}
