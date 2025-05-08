package com.codeid.eshopay.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeid.eshopay.model.dto.SuppliersDto;
import com.codeid.eshopay.service.BaseCrudService;
import com.codeid.eshopay.service.SuppliersService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/supplier/")
@Slf4j
@RequiredArgsConstructor
public class SuppliersController extends BaseCrudController<SuppliersDto, Long>{
    private final SuppliersService suppliersService;

    @Override
    protected BaseCrudService<SuppliersDto, Long> getService(){
        return suppliersService;
    }

    @Override
    public ResponseEntity<SuppliersDto> create(@Valid SuppliersDto entity) {
        return super.create(entity);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return super.delete(id);
    }

    @Override
    public ResponseEntity<List<SuppliersDto>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<SuppliersDto> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<SuppliersDto> update(Long id, @Valid SuppliersDto entity) {
        return super.update(id, entity);
    }
}