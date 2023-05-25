package com.blogapplication.blogapplication.service;

import java.util.List;
import java.util.Optional;

import com.blogapplication.blogapplication.entity.Post;
import com.blogapplication.blogapplication.payload.PostDTO;
import com.blogapplication.blogapplication.payload.PostResponse;

public interface PostService {
    PostDTO createPost(PostDTO postDto);
    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
    Post getPostById(Long postId);
    PostDTO updatePost(Long blogId, PostDTO postDto);
    String deletePost(Long postId);
}
