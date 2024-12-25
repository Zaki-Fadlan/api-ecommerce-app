package com.zakifadlan.ecommerceapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/carts")
public class CartController {
//Get All
    @GetMapping()
    public ResponseEntity<String> list(){
        return new ResponseEntity<String>("Cart list Product", HttpStatus.OK);
    }
//    Add To cart
    @PostMapping()
    public ResponseEntity<String> save(){
        return new ResponseEntity<String>("Add Product to cart",HttpStatus.OK);
    }
    //    Delete From cart
    @DeleteMapping("/{id}")
        public ResponseEntity<String> delete(){
            return new ResponseEntity<String>("Delete product from cart", HttpStatus.OK);
    }
    //    Update Qty
    @PutMapping("/{id}")
        public ResponseEntity<String> update(){
            return new ResponseEntity<String>("Update QTY", HttpStatus.OK);
}
}
