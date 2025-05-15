package com.codeid.ushopay.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImagesDto {
    
    private Integer prodImId;

    private String fileName;
    
    private float fileSize;

    private String fileType;

    private String fileUri;

    private Integer productId;
}