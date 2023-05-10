package com.blogapplication.blogapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.blogapplication.entity.Comment;
import com.blogapplication.blogapplication.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("posts/{postId}/comments")
    public Comment createPost(
        @PathVariable("postId") Long postId,
        @RequestBody Comment comment
    )
    {
        return commentService.createComment(postId, comment);
    }

    @GetMapping("posts/{postId}/comments")
    public List<Comment> getAllCommentsByPost(
            @PathVariable("postId") Long postId
    ) {
        return commentService.getAllCommentsByPost(postId);
    }

    @GetMapping("posts/{postId}/comments/{commentId}")
    public Comment getCommentById(
        @PathVariable("postId") Long postId,
        @PathVariable("commentId") Long commentId
    )
    {
        return commentService.getCommentById(postId, commentId);
    }
}
