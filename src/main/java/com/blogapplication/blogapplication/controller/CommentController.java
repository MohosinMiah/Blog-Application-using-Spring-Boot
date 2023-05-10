package com.blogapplication.blogapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    
}
