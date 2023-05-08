package com.blogapplication.blogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapplication.blogapplication.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
}
