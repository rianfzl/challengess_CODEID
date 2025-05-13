package com.codeid.ushopay.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codeid.ushopay.model.dto.ProductsDto;
import com.codeid.ushopay.model.enumeration.EnumStatus;
import com.codeid.ushopay.model.response.ApiResponse;
import com.codeid.ushopay.service.BaseCrudService;
import com.codeid.ushopay.service.FileStorageService;
import com.codeid.ushopay.service.ProductsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/")
public class ProductsController extends BaseMultiPartController<ProductsDto, Integer>{
    
    private final ProductsService productService;
    private final FileStorageService fileStorageService;

    @Override
    protected BaseCrudService<ProductsDto, Integer> getService() {
        return productService;    
    }
    
    @Override
    public ResponseEntity<ProductsDto> create(@Valid ProductsDto entity) {
        return super.create(entity);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return super.delete(id);
    }

    @Override
    public ResponseEntity<List<ProductsDto>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<ProductsDto> getById(Integer id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<ProductsDto> update(Integer id, @Valid ProductsDto entity) {
        return super.update(id, entity);
    }

    @Override
    public ResponseEntity<?> createMultipart(ProductsDto dto, MultipartFile file, String description) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload product photo");
        }

        try {
            String fileName = fileStorageService.storeFileWithRandomName(file);
            
            dto.setPhoto(fileName);
            var productsDto= productService.save(dto);    

            ApiResponse<ProductsDto> response = new ApiResponse<ProductsDto>(EnumStatus.Succeed.toString(), "Product created", productsDto);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }    
    }

    @Override
    public ResponseEntity<?> viewImage(String fileName) {
        try {
            Resource resource = fileStorageService.loadFile(fileName);
            
            // Cek jika file adalah image
            String contentType = determineContentType(fileName);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, 
                           "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }    
    }

    @Override
    public ResponseEntity<?> updateMultipart(Integer id, ProductsDto dto, MultipartFile file, String description) {
        throw new UnsupportedOperationException("Unimplemented method 'updateMultipart'");
    }
    
}