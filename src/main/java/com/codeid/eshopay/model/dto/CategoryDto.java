package com.codeid.eshopay.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long categoryId;

    @Size(max = 50, message = "Length value must not exceeded than 50")
    private String categoryName;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;
}
