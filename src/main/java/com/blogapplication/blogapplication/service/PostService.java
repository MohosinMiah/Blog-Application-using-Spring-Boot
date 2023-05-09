package com.blogapplication.blogapplication.service;

import java.util.List;
import java.util.Optional;

import com.blogapplication.blogapplication.entity.Post;
import com.blogapplication.blogapplication.payload.PostResponse;

public interface PostService {
    Post createPost(Post post);
    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
    Post getPostById(Long postId);
    Post updatePost(Long blogId, Post post);
    String deletePost(Long postId);
}
