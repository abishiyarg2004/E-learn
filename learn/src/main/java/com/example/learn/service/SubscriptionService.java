package com.example.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learn.model.SubscriptionModel;
import com.example.learn.repository.SubscriptionRepo;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepo subscriptionRepository;
   
    public SubscriptionModel saveSubscription(SubscriptionModel subscription) {
        return subscriptionRepository.save(subscription);
    }
   
    public List<SubscriptionModel> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }
    
    public SubscriptionModel getSubscriptionById(int id) {
        return subscriptionRepository.findById(id).orElse(null);
    }
   
    public SubscriptionModel updateSubscription(int id, SubscriptionModel subscription) {
        SubscriptionModel existingSubscription = subscriptionRepository.findById(id).orElse(null);
        if (existingSubscription != null) {
            existingSubscription.setName(subscription.getName());
            existingSubscription.setDetails(subscription.getDetails());
            existingSubscription.setSubtype(subscription.getSubtype());
            existingSubscription.setUsers(subscription.getUsers());
            return subscriptionRepository.save(existingSubscription);
        }
        return null;
    }
   
    public void deleteSubscription(int id) {
        subscriptionRepository.deleteById(id);
    }
}
