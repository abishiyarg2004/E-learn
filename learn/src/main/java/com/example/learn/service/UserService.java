package com.example.learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learn.model.Usermodel;
import com.example.learn.repository.UserRepository;
import com.example.learn.utils.ReturnUser;

@Service
public class UserService {
    
    @Autowired
    public UserRepository userRepository;

//    public void setLoggettrue(int id){
//           userRepository.setloggedtrue(id);
          
//    }
   public void setLoggetfalse(int id){
          userRepository.setloggedfalse(id);
          
   }

   public ReturnUser getlogged(){
    Usermodel user= userRepository.getloggedUser();
   return  ReturnUser.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .build();

   }

    public List<ReturnUser> getallUsers() {
        List<Usermodel> users = userRepository.findAll(); 
        return users.stream()
                .map(user -> ReturnUser.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .build())
                .collect(Collectors.toList()); 
    }
    public List<Usermodel> getAllusers(){
       return userRepository.findAll();
    }

    public void deleteuser(int id){
       userRepository.deleteById(id);
    }
}
