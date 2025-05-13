package com.codeid.ushopay.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codeid.ushopay.model.dto.ProductsDto;
import com.codeid.ushopay.model.entity.Category;
import com.codeid.ushopay.model.entity.Products;
import com.codeid.ushopay.model.entity.Suppliers;
import com.codeid.ushopay.repository.ProductsRepository;
import com.codeid.ushopay.service.ProductsService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService{
    private final ProductsRepository productsRepository;

    public static ProductsDto mapToDto(Products products){
        return new ProductsDto(products.getProductId(),
        products.getProductName(),
        products.getQuantityPerUnit(),
        products.getUnitPrice(),
        products.getUnitsInStock(),
        products.getUnitsOnOrder(),
        products.getReorderLevel(),
        products.getDiscontinued(),
        products.getPhoto(),
        SuppliersServiceImpl.mapToDto(products.getSuppliers()),
        CategoryServiceImpl.mapToDto(products.getCategory()));
    }

    private Products mapToEntity(ProductsDto productsDto){
        return new Products(productsDto.getProductId(),
        productsDto.getProductName(),
        productsDto.getQuantityPerUnit(),
        productsDto.getUnitPrice(),
        productsDto.getUnitsInStock(),
        productsDto.getUnitsOnOrder(),
        productsDto.getReorderLevel(),
        productsDto.getDiscontinued(),
        productsDto.getPhoto(),
        SuppliersServiceImpl.mapToEntity(productsDto.getSupplier()),
        CategoryServiceImpl.mapToEntity(productsDto.getCategory()));
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete product : {}", id);

        var products = this.productsRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("Product not found with id "+id));

       this.productsRepository.deleteById(products.getProductId());
    }

    @Override
    public List<ProductsDto> findAll() {
        log.debug("Request to get all Products");
        return this.productsRepository.findAll().stream()
                .map(ProductsServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductsDto findById(Integer id) {
        log.debug("Request to get Product : {}", id);
        return this.productsRepository.findById(id).map(ProductsServiceImpl::mapToDto)
            .orElseThrow(()-> new EntityNotFoundException("Product not found with id "+id));
    }

    @Override
    public ProductsDto save(ProductsDto entity) {
        log.debug("Request to create Product : {}", entity);
        var product = mapToEntity(entity);
        return mapToDto(this.productsRepository.save(product));    
    }

    @Override
    public ProductsDto update(Integer id, ProductsDto entity) {
        log.debug("Request to update Product : {}", id);
        var products = this.productsRepository
                            .findById(id)
                            .orElseThrow(()-> new EntityNotFoundException("Product not found with id "+id));
        
        products.setProductName(entity.getProductName());
        products.setQuantityPerUnit(entity.getQuantityPerUnit());
        products.setUnitPrice(entity.getUnitPrice());
        products.setUnitsInStock(entity.getUnitsInStock());
        products.setUnitsOnOrder(entity.getUnitsOnOrder());
        products.setReorderLevel(entity.getReorderLevel());
        products.setDiscontinued(entity.getDiscontinued());
        products.setSuppliers(new Suppliers(entity.getSupplier().getSuppliersId(), entity.getSupplier().getCompanyName()));
        products.setCategory(new Category(entity.getCategory().getCategoryId(), entity.getCategory().getCategoryName(),
                                    entity.getCategory().getDescription(), entity.getCategory().getPicture()));

        this.productsRepository.save(products);
        return mapToDto(products);
    }
}
