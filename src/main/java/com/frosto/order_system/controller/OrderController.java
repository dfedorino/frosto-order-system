package com.frosto.order_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    public static final String BASE_URL = "/api/v1/orders";
    @GetMapping(path = BASE_URL + "/{orderId}")
    public ResponseEntity<String> getOrder(@PathVariable long orderId) {
        return ResponseEntity.ok("Request for order with id: " + orderId);
    }

    @PostMapping(BASE_URL)
    public ResponseEntity<String> createOrder() {
        return ResponseEntity.ok("Request to create a new order");
    }

    @DeleteMapping(path = BASE_URL + "/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable long orderId) {
        return ResponseEntity.ok("Request to delete the order with id: " + orderId);
    }
}
