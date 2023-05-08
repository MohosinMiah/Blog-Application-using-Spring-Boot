package com.blogapplication.blogapplication.service;

import com.blogapplication.blogapplication.payload.PostDTO;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    PostDTO getAllPost();
}
