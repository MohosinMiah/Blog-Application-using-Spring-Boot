package com.blogapplication.blogapplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.entity.Comment;
import com.blogapplication.blogapplication.entity.Post;
import com.blogapplication.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.blogapplication.repository.CommentRepository;
import com.blogapplication.blogapplication.repository.PostRepository;
import com.blogapplication.blogapplication.service.CommentService;





@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public Comment createComment(Long postId, Comment comment) {
        // TODO Auto-generated method stub
        Post post = postRepository.findById(postId).orElseThrow( ()-> new ResourceNotFoundException("Post","Id",postId));
        
        comment.setPost(post);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public List<Comment> getAllCommentsByPost(Long postId) {
        return commentRepository.findByPostId(postId);
    }

 
    
}
