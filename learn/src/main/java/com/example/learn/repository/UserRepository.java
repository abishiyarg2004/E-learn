package com.example.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.learn.model.Usermodel;
import com.example.learn.utils.ReturnUser;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<Usermodel, Integer> {
    Usermodel findByEmail(String email);

    @Transactional
    @Modifying
    @Query("Update Usermodel u set logged=true where email=?1")
    void setloggedtrue(String email);

    @Transactional
    @Modifying
    @Query("Update Usermodel u set logged=false where id=?1")
    void setloggedfalse(int id);


  
    @Query("select u from Usermodel u where logged= true")
    Usermodel getloggedUser();
}
