package com.zakifadlan.ecommerceapp.service.impl;

import com.zakifadlan.ecommerceapp.model.Product;
import com.zakifadlan.ecommerceapp.repository.ProductRepository;
import com.zakifadlan.ecommerceapp.service.ProductService;
import com.zakifadlan.ecommerceapp.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    public TemplateResponse templateResponse;

    @Autowired
    public ProductRepository productRepository;

    @Override
    public Map insertProduct(Product product) {
        try {
            if (templateResponse.checkNull(product)) {
                return templateResponse.templateError("Product or required fields are missing");
            }
            Product prodObj = productRepository.save(product);
            String successMessage = String.format(
                    "Product '%s' has been successfully added",
                    prodObj.getName()
            );
            return templateResponse.templateSucces(prodObj,successMessage,"201");
        }catch (Exception e){
            return templateResponse.templateError(e);
        }
    }

    @Override
    public Map updateProduct(Product product) {
        try {
            return templateResponse.templateSucces(product,"update Success","200");
        }catch (Exception e){
            return templateResponse.templateError(e);
        }
    }

    @Override
    public Map deleteProduct(UUID product) {
        try {
            return templateResponse.templateSucces(product,"Delete Success","200");
        }catch (Exception e){
            return templateResponse.templateError(e);
        }
    }

    @Override
    public Map getAllProduct(int size, int page) {
        Map map = new HashMap<>();
        map.put("Size",size);
        map.put("Page",page);
        try {
            return templateResponse.templateSucces(map,"Insert Success","200");
        }catch (Exception e){
            return templateResponse.templateError(e);
        }
    }
}
