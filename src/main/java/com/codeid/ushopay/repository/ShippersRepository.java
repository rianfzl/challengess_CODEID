package com.codeid.ushopay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeid.ushopay.model.entity.Shippers;

@Repository
public interface ShippersRepository extends JpaRepository<Shippers, Long> {
    
}