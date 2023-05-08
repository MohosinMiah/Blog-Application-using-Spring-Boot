package com.blogapplication.blogapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.entity.Post;
import com.blogapplication.blogapplication.payload.PostDTO;
import com.blogapplication.blogapplication.repository.PostRepository;
import com.blogapplication.blogapplication.service.PostService;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        // Create a new post
        Post post = new Post();
        mapToPost(postDTO, post);

        Post newPost = postRepository.save(post);

        // New post return response in PostDTO formate
        PostDTO postResponse = new PostDTO();
        mapToPostDTO(newPost, postResponse);

        return postResponse;
    }

    private void mapToPostDTO(Post newPost, PostDTO postResponse) {
        postResponse.setTitle(newPost.getTitle());
        postResponse.setContent(newPost.getContent());
        postResponse.setDescription(newPost.getDescription());
    }

    private void mapToPost(PostDTO postDTO, Post post) {
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
    }



    @Override
    public PostDTO getAllPost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPost'");
    }
    
}
