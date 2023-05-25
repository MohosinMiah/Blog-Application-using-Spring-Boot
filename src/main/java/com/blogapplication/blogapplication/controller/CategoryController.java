package com.blogapplication.blogapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.blogapplication.payload.CategoryDto;
import com.blogapplication.blogapplication.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }


    @GetMapping
    public List<CategoryDto> getCategoryList()
    {
        return categoryService.getCategoryList();
    }

    @GetMapping("/{categoryId}")
    public CategoryDto getCategoryById( @PathVariable("categoryId") Long categoryId )
    {
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/{categoryId}")
    public CategoryDto updateCategoryById( @PathVariable("categoryId") Long categoryId , @RequestBody CategoryDto categoryDto )
    {
        return categoryService.updateCategoryById(categoryId, categoryDto );
    }


    @DeleteMapping("/{categoryId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CategoryDto deleteCategoryById( @PathVariable("categoryId") Long categoryId , @RequestBody CategoryDto categoryDto )
    {
        return categoryService.deleteCategoryById(categoryId);
    }

}
