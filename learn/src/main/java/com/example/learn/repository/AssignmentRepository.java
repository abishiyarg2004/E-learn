package com.example.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learn.model.AssignmentModel;

public interface AssignmentRepository extends JpaRepository<AssignmentModel,Integer> {

}
