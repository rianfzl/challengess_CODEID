package com.codeid.eshopay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeid.eshopay.model.entity.Shippers;

@Repository
public interface ShippersRepository extends JpaRepository<Shippers, Long> {
    
}