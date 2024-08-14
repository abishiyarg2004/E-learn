package com.example.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learn.model.Usermodel;
import com.example.learn.service.UserService;
import com.example.learn.utils.ReturnUser;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;







@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;
    
    

    @PutMapping("loggedfalse/{id}")
    public void putfalse(@PathVariable int id) {
        userService.setLoggetfalse(id);
        
    }
   
    @GetMapping("/getloggeduser")
    public ReturnUser getMethodName() {
        return userService.getlogged();
    }
    

    @GetMapping("/allusers")
    public List<Usermodel> gettingallusers() {
        return userService.getAllusers();
    }

    @DeleteMapping("/deleting/{id}")
    public void deleteuser(@PathVariable int id){
        userService.deleteuser(id);
    }

    
    
    
}
