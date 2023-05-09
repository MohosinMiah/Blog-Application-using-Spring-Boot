package com.blogapplication.blogapplication.service;

import java.util.List;
import java.util.Optional;

import com.blogapplication.blogapplication.entity.Post;

public interface PostService {
    Post createPost(Post post);
    List<Post> getAllPost();
    Post getPostById(Long postId);
    Post updatePost(Long blogId, Post post);
    String deletePost(Long postId);
}
