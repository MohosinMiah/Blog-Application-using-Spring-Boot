package com.blogapplication.blogapplication.service;

import com.blogapplication.blogapplication.entity.Comment;

public interface CommentService {
    Comment createComment(Long postId, Comment comment);
}
