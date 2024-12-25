package com.zakifadlan.ecommerceapp.utils;

import com.zakifadlan.ecommerceapp.model.Product;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {
    @Value("${app.base-url}")
    private String baseUrl;
    @Override
    public EntityModel<Product> toModel(Product product) {

        EntityModel<Product> productModel = EntityModel.of(product);
        String productUrl = baseUrl + "/v1/products/" + product.getId();

        Link selfLink = Link.of(productUrl).withSelfRel();
        productModel.add(selfLink);


        return productModel;
    }
}

