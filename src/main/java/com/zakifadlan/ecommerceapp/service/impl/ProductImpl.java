package com.zakifadlan.ecommerceapp.service.impl;

import com.zakifadlan.ecommerceapp.model.Product;
import com.zakifadlan.ecommerceapp.repository.ProductRepository;
import com.zakifadlan.ecommerceapp.service.ProductService;
import com.zakifadlan.ecommerceapp.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
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
    public Map getProductByID(UUID id) {
        try {
            Optional<Product> checkIdProduct = productRepository.findById(id);
            if (checkIdProduct.isEmpty()){
                return templateResponse.templateError("Product not found");
            }
            Product product = checkIdProduct.get();
            String successMessage = String.format(
                    "Product '%s' has founded",
                    product.getName()
            );
            return templateResponse.templateSucces(product,successMessage,"200");
        }catch (Exception e){
            return templateResponse.templateError(e);
        }
    }



    @Override
    public Map updateProduct(Product product) {
        try {
            if (templateResponse.chekNull(product.getId())){
                return templateResponse.templateError("Product or required fields are missing");
            }
            Optional<Product> checkIdProduct = productRepository.findById(product.getId());
            if (checkIdProduct.isEmpty()){
                return templateResponse.templateError("Product not found");
            }
            Product updatedProduct = productRepository.save(product);
            String successMessage = String.format(
                    "Product '%s' has been successfully updated",
                    product.getName()
            );
            return templateResponse.templateSucces(updatedProduct,successMessage,"200");
        }catch (Exception e){
            return templateResponse.templateError(e);
        }
    }

    @Override
    public Map deleteProduct(UUID product) {
        try {
            if (templateResponse.chekNull(product)){
                return templateResponse.templateError("Product or required fields are missing");
            }
            Optional<Product> checkIdProduct = productRepository.findById(product);
            if (checkIdProduct.isEmpty()){
                return templateResponse.templateError("Product not found");
            }
            Product existingProduct = checkIdProduct.get();
            existingProduct.setDeleted_date(new Date());
            Product updatedProduct = productRepository.save(existingProduct);
            String successMessage = String.format(
                    "Product '%s' has been successfully marked as deleted",
                    updatedProduct.getName()
            );
            return templateResponse.templateSucces(updatedProduct,successMessage,"200");
        }catch (Exception e){
            return templateResponse.templateError(e);
        }
    }


}
