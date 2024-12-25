package com.zakifadlan.ecommerceapp.controller;

import com.zakifadlan.ecommerceapp.model.Product;
import com.zakifadlan.ecommerceapp.repository.ProductRepository;
import com.zakifadlan.ecommerceapp.service.ProductService;
import com.zakifadlan.ecommerceapp.utils.ProductModelAssembler;
import com.zakifadlan.ecommerceapp.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public TemplateResponse templateResponse;
    @Autowired
    private ProductModelAssembler productModelAssembler;
    @Autowired
    private PagedResourcesAssembler<Product> pagedResourcesAssembler;
    //    Create
    @PostMapping()
    public ResponseEntity<Map> save(@RequestBody Product product){

        Map obj = productService.insertProduct(product);
        return new ResponseEntity<Map>(obj, HttpStatus.CREATED);
    }
    //    Get All
    @GetMapping()
    public ResponseEntity<Map> list(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String name

    ){
        Map map = new HashMap<>();
        Pageable show_data = PageRequest.of(page,size, Sort.by("name").descending());
        Page<Product> productPage;

        if(name!=null&&!name.isEmpty()){
            productPage = productRepository.findByNameContainingIgnoreCase(name, show_data);
        }else {
            productPage = productRepository.findAll(show_data);
        }
        PagedModel<EntityModel<Product>> pagedModel = pagedResourcesAssembler.toModel(productPage,productModelAssembler);

        return new ResponseEntity<Map>(templateResponse.templateSucces(pagedModel,"Success Get All data","200"), HttpStatus.OK);
    }
    //    Update
    @PutMapping()
    public ResponseEntity<Map> update(@RequestBody Product product){
        Map obj = productService.updateProduct(product);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }
    //    Get By ID
    @GetMapping("/{id}")
    public ResponseEntity<Map> getId(@PathVariable(value = "id")UUID id){
        Map product = productService.getProductByID(id);
        return new ResponseEntity<Map>(product, HttpStatus.OK);
    }
    //    Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id")UUID id){
        Map product = productService.deleteProduct(id);
        return new ResponseEntity<Map>(product, HttpStatus.OK);
    }
}
