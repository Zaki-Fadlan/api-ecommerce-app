package com.zakifadlan.ecommerceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/hello")
public class HelloController {
    @Autowired
    @GetMapping
    public ResponseEntity<String> coba(){
        return new ResponseEntity<String>("Halo", HttpStatus.OK);
    }
}