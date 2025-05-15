package com.codeid.ushopay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codeid.ushopay.model.entity.ProductImages;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Integer>{
    //jpql, basedn on object
    @Query(value="SELECT p from ProductImages p where p.products.productId=:id")
    List<ProductImages> findProductImagesByProductIdJpql(@Param("id") Integer id);

    //nativesql
    @Query(value="SELECT * FROM oe.product_images p where p.product_id=:id",nativeQuery = true)
    List<ProductImages> findProductImagesByProductIdSql(@Param("id") Integer id);
}