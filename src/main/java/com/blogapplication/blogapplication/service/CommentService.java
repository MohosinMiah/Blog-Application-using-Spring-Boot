package com.blogapplication.blogapplication.service;

import java.util.List;
import java.util.Optional;

import com.blogapplication.blogapplication.entity.Comment;

public interface CommentService {
    Comment createComment(Long postId, Comment comment);

    List<Comment> getAllCommentsByPost(Long postId);

    Comment getCommentById(Long postId, Long commentId);

    Comment updateCommentById(Long postId, Long commentId, Comment comment);

}
