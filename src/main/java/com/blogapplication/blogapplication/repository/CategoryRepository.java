package com.blogapplication.blogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapplication.blogapplication.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
