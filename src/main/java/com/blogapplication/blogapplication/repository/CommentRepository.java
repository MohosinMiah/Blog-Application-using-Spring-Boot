package com.blogapplication.blogapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapplication.blogapplication.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

    List<Comment> findByPostId(Long postId);
    
}
