package com.example.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learn.model.Coursemodel;
import com.example.learn.service.CourseService;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    public CourseService courseService;

    @GetMapping("/getting")
    public List<Coursemodel> getting() {
        return courseService.getting();
    }
    
    @PostMapping("/postinglist")
    public String postMethodName(@RequestBody List<Coursemodel> courses) {
        for(Coursemodel course:courses){
           courseService.posting(course);
        }
        return "posted";
    }
    


    @PostMapping("/posting")
    public String posting(@RequestBody Coursemodel course) {
        
        
        return courseService.posting(course);
    }
    
    @DeleteMapping("/deleting/{id}")
    public String deleting(@PathVariable int id){
        return courseService.deleting(id);
    }

    @PutMapping("enroll/{id}")
    public String setEnrolledTrue(@PathVariable int id) {
        
        
        return courseService.enrolledTrue(id);
        
    }

    @GetMapping("/enrolledcourses")
    public List<Coursemodel> getenrolledcourses() {
        return courseService.enrolledCourses();
    }

    @PutMapping("/unenroll/{id}")
    public String setEnrolledFalse(@PathVariable int id) {
        
        
        return courseService.enrolledFalse(id);
    }

    @PutMapping("/update/{id}")
    public String updating(@PathVariable int id, @RequestBody Coursemodel course) {
       
        
        return courseService.putting(id,course);
    }
    
    @GetMapping("/getbyid/{id}")
    public Optional<Coursemodel> getMethodName(@PathVariable int id) {
        return courseService.getbyid(id);
    }
    
    
}
