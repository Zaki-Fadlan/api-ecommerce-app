package com.zakifadlan.ecommerceapp.controller;

import com.zakifadlan.ecommerceapp.model.Product;
import com.zakifadlan.ecommerceapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

//    Create
    @PostMapping()
    public ResponseEntity<Map> save(@RequestBody Product product){

        Map obj = productService.insertProduct(product);
        return new ResponseEntity<Map>(obj, HttpStatus.CREATED);
    }
//    Get All
    @GetMapping()
    public ResponseEntity<String> list(){
        return new ResponseEntity<String>("List Product", HttpStatus.OK);
    }
//    Get By ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getId(){
        return new ResponseEntity<String>("Get By ID Product", HttpStatus.OK);
    }
//    Update
    @PutMapping("/{id}")
    public ResponseEntity<String> update(){
        return new ResponseEntity<String>("UpdateProduct", HttpStatus.OK);
    }
//    Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(){
        return new ResponseEntity<String>("Delete Product", HttpStatus.OK);
    }
}
