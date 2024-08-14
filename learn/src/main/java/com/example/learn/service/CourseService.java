package com.example.learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.learn.model.Coursemodel;
import com.example.learn.repository.CourseRepo;

@Service
public class CourseService {
    
    @Autowired
    public CourseRepo courseRepo;


    public List<Coursemodel> getting(){
        return courseRepo.findAll();
    }

    public String deleting(int id){
        courseRepo.deleteById(id);
        return "deleted";
    }

    public String posting(Coursemodel course){
        courseRepo.save(course);
        return "course added";
    }

    public String enrolledTrue(int id){
        courseRepo.setEnrolledTrue(id);
        return "enrolled course";
    }

    public List<Coursemodel> enrolledCourses(){
        return courseRepo.enrolledcourses();
    }

    public String enrolledFalse(int id){
        courseRepo.setEnrolledFalse(id);
        return "unenrolled course";
    }

    public String putting(int id,Coursemodel course){
        if(courseRepo.existsById(id)){
            course.setId(id);
        }
        courseRepo.save(course);
        return "Updated course";
    }

    public Optional<Coursemodel> getbyid(int id){
        return courseRepo.findById(id);
    }


}
