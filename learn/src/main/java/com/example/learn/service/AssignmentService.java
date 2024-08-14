package com.example.learn.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.learn.model.AssignmentModel;
import com.example.learn.repository.AssignmentRepository;


@Service
public class AssignmentService {

    @Autowired
    public AssignmentRepository assignmentRepository;



    public void posting(AssignmentModel assignment){
assignmentRepository.save(assignment);
    }

    public List<AssignmentModel> getting(){
      return  assignmentRepository.findAll();
    }

      public void submitAssignment(int assignmentId, AssignmentModel assignmentData) {
    
       

        
        assignmentData.setId(assignmentId); 
        assignmentData.setStatus("submitted"); 
       
        assignmentRepository.save(assignmentData);
    }
}
