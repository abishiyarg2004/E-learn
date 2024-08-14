package com.example.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learn.model.SubscriptionModel;
import com.example.learn.service.SubscriptionService;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptioController {

      @Autowired
    private SubscriptionService subscriptionService;
    @PostMapping("/posting")
    public ResponseEntity<SubscriptionModel> createSubscription(@RequestBody SubscriptionModel subscription) {
        return ResponseEntity.ok(subscriptionService.saveSubscription(subscription));
    }
    @GetMapping("/getting")
    public ResponseEntity<List<SubscriptionModel>> getAllSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
    }
    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionModel> getSubscriptionById(@PathVariable int id) {
        return ResponseEntity.ok(subscriptionService.getSubscriptionById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionModel> updateSubscription(@PathVariable int id, @RequestBody SubscriptionModel subscription) {
        return ResponseEntity.ok(subscriptionService.updateSubscription(id, subscription));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable int id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }
}
