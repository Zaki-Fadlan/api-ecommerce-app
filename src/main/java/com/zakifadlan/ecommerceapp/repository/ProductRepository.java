package com.zakifadlan.ecommerceapp.repository;

import com.zakifadlan.ecommerceapp.model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
        Page<Product> findAll(Pageable pageable);
        public Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
