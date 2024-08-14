package com.example.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.learn.model.Coursemodel;

import jakarta.transaction.Transactional;

@Repository
public interface CourseRepo extends JpaRepository<Coursemodel,Integer> {

    


    @Transactional
    @Modifying
    @Query("update Coursemodel c set c.enrolled = true where id=?1")
    int setEnrolledTrue(int id);


    @Transactional
    @Modifying
    @Query("select c from Coursemodel c where c.enrolled = true")
    List<Coursemodel> enrolledcourses();

    @Transactional
    @Modifying
    @Query("update Coursemodel c set c.enrolled = false where id=?1")
    int setEnrolledFalse(int id);

    
}
