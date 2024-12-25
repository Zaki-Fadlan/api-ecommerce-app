package com.zakifadlan.ecommerceapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/orders")
public class OrderController {
    @PostMapping
    public ResponseEntity<String> save(){
        return new ResponseEntity<String>("Add order", HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<String> list(){
        return new ResponseEntity<String>("Order List", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> orderById(){
        return new ResponseEntity<String>("Order by ID", HttpStatus.OK);
    }
    @GetMapping("/history")
    public ResponseEntity<String> orderHistory(){
        return new ResponseEntity<String>("Order History",HttpStatus.OK);
    }
}
