package com.blogapplication.blogapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.entity.Post;
import com.blogapplication.blogapplication.repository.PostRepository;
import com.blogapplication.blogapplication.service.PostService;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        // Create a new post
        return postRepository.save(post);
    }

 



    @Override
    public List<Post> getAllPost() {
        // TODO Auto-generated method stub
        return postRepository.findAll();
    }
    
}
