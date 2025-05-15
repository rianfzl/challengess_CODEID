package com.codeid.ushopay.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.codeid.ushopay.model.dto.ProductImagesDto;

public interface ProductImagesService extends BaseCrudService<ProductImagesDto, Integer>{
    List<ProductImagesDto> findProductPhotosByProductId(Integer id);
    List<ProductImagesDto> bulkInsert(Integer productId, MultipartFile[] files);
}