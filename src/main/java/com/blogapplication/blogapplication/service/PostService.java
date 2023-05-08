package com.blogapplication.blogapplication.service;

import java.util.List;

import com.blogapplication.blogapplication.entity.Post;

public interface PostService {
    Post createPost(Post post);
    List<Post> getAllPost();
}
