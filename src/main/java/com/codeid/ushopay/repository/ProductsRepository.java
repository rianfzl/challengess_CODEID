package com.codeid.ushopay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeid.ushopay.model.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>{
    
}