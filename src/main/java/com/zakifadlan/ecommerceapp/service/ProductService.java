package com.zakifadlan.ecommerceapp.service;

import com.zakifadlan.ecommerceapp.model.Product;

import java.util.Map;
import java.util.UUID;

public interface ProductService {
    public Map insertProduct(Product product);
    public Map getProductByID(UUID id);
    public Map updateProduct(Product product);
    public Map deleteProduct(UUID product);
}
