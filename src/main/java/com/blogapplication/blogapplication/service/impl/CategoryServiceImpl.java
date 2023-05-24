package com.blogapplication.blogapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.entity.Category;
import com.blogapplication.blogapplication.exception.ResourceNotFoundException;
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





    @Override
    public List<CategoryDto> getCategoryList() {
        // Get Category List
        List<Category> categories =  categoryRepository.findAll();

        // Convert Category Entity list to CategoryDto List
        List<CategoryDto> categoriesDtos = categories
        .stream()
        .map(user -> modelMapper.map(user, CategoryDto.class))
        .collect(Collectors.toList());
        
        return categoriesDtos;
    }

    @Override
    public CategoryDto updateCategoryById(Long categoryId, CategoryDto categoryDto) {
        // Update by ID
        // Get Category By ID
        Category category = categoryRepository.findById(categoryId).get();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepository.save(category);

        Category updatedCategory = categoryRepository.findById(categoryId).get();

        // Convert category entity to map category

        CategoryDto responseCategory = modelMapper.map(updatedCategory, CategoryDto.class);


        return responseCategory;

    }

    @Override
    public CategoryDto deleteCategoryById(Long categoryId) {
        // Check Category is exist 
         // Get Category By ID
         Category category = categoryRepository.findById(categoryId).orElseThrow( () -> new ResourceNotFoundException("Category Resource", "Categeopry ID", categoryId));

         System.out.println(category);

         System.out.println("With Category Get");

         System.out.println(categoryRepository.findById(categoryId).get());


         if(category.getId() == categoryId)
         {
            categoryRepository.deleteById(category.getId());
         }
         

         return modelMapper.map(category, CategoryDto.class);
    }
    
}
