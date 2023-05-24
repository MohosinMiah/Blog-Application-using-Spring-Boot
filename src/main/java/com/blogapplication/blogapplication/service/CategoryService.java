package com.blogapplication.blogapplication.service;

import java.util.List;

import com.blogapplication.blogapplication.payload.CategoryDto;

public interface CategoryService {

    public CategoryDto addCategory(CategoryDto categoryDto);

    public CategoryDto getCategoryById(Long categoryId);

    public List<CategoryDto> getCategoryList();

    public CategoryDto updateCategoryById(Long categoryId, CategoryDto categoryDto);
    
}
