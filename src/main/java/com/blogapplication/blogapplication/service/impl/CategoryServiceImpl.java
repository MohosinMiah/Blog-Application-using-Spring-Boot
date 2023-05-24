package com.blogapplication.blogapplication.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.entity.Category;
import com.blogapplication.blogapplication.payload.CategoryDto;
import com.blogapplication.blogapplication.repository.CategoryRepository;
import com.blogapplication.blogapplication.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    // @Autowired
    ModelMapper modelMapper;

    public CategoryServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {

        // Convert CategoryDto to Category Entity
        Category category = modelMapper.map(categoryDto, Category.class);
        // Save the category
        Category saveCategory  =  categoryRepository.save(category);

        return modelMapper.map(saveCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        // Get Category By ID
        Category category = categoryRepository.findById(categoryId).get();
        return modelMapper.map(category,CategoryDto.class);
    }
    
}
