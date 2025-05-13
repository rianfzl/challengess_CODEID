package com.codeid.ushopay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.codeid.ushopay.model.entity.Category;
import com.codeid.ushopay.repository.CategoryRepository;
import com.codeid.ushopay.service.implementation.CategoryServiceImpl;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class CategoryTests {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void testFindById() {
        // arrange
        // data source
        Category mockDept = new Category();
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(mockDept));

        // act
        var result = categoryService.findById(1L);

        // assert
        assertNotNull(result);
        assertEquals("Pantry", result.getCategoryName());
    }

    @Test
    void testFindById_notFound_throwsException() {
        // Arrange
        when(categoryRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        EntityNotFoundException ex = assertThrows(EntityNotFoundException.class, () -> {
            categoryService.findById(99L);
        });

        assertEquals("Category not found with id 99", ex.getMessage());
    }


    @Test
    void testSave_success() {
        //arrange"
        var input = new Category("Milk");
        var saved = new Category("Milk");

        when(categoryRepository.save(input)).thenReturn(saved);
        
        var inputDto = CategoryServiceImpl.mapToDto(input);
        
        //act
        var result = categoryService.save(inputDto);

        //assert
        assertNotNull(result.getCategoryId());
        assertEquals("Milk", result.getCategoryName());
    }

    @Test
    void testDelete_success() {
        //1. arrange
        Long CategoryId = 1L;
        Category mockDept = new Category("Food");

        //mockup repository response
        when (categoryRepository.findById(CategoryId)).thenReturn(Optional.of(mockDept));

        //mock void method
        doNothing().when(categoryRepository).delete(mockDept);

        //2. act
        categoryService.delete(CategoryId);

        // assert
        //verifikasi :
        //1. findById() Call 1x with parameter
        //2. delete() call 1x dengan object yg benar
        verify(categoryRepository,times(1)).findById(CategoryId);
        verify(categoryRepository,times(1)).delete(mockDept);
    }
}