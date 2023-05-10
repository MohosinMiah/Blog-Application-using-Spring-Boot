package com.blogapplication.blogapplication.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapplication.blogapplication.entity.Comment;
import com.blogapplication.blogapplication.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    
}
