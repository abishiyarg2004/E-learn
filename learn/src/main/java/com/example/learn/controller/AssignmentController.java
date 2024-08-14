package com.example.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.learn.model.AssignmentModel;
import com.example.learn.service.AssignmentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin
@RequestMapping("/assignment")
public class AssignmentController {

    @Autowired
    public AssignmentService assignmentService;

    @GetMapping("/getting")
    public List<AssignmentModel> getMethodName() {
        return assignmentService.getting();
    }
    @PostMapping("/posting")
    public void postMethodName(@RequestBody AssignmentModel assignment) {
       assignmentService.posting(assignment);
    }
    
    @PostMapping("/submit/{id}")
    public ResponseEntity<String> submitAssignment(
            @PathVariable("id") int assignmentId,
            @RequestBody AssignmentModel assignmentData) {

        
            assignmentService.submitAssignment(assignmentId, assignmentData);
            return new ResponseEntity<>("Assignment submitted successfully!", HttpStatus.OK);
       
    }
    
}
