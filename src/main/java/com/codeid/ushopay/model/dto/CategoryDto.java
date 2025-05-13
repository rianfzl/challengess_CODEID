package com.codeid.ushopay.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CategoryDto {
    
    private Integer categoryId;

    @Size(max = 15, message = "Maximum length of category name is 15")
    @NonNull
    private String categoryName;

    private String description;

    private byte[] picture;
}