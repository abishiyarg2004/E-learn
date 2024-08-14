package com.example.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learn.model.SubscriptionModel;

public interface SubscriptionRepo  extends JpaRepository<SubscriptionModel,Integer>{

}
