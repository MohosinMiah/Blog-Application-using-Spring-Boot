package com.blogapplication.blogapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.blogapplication.entity.Post;
import com.blogapplication.blogapplication.payload.PostDTO;
import com.blogapplication.blogapplication.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    
    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost( @RequestBody Post post)
    {
        return postService.createPost(post);
    }


    @GetMapping
    public List<Post> getAllPost()
    {
        return postService.getAllPost();
    }

}
