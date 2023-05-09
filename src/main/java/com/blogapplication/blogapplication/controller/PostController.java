package com.blogapplication.blogapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.blogapplication.entity.Post;
import com.blogapplication.blogapplication.payload.PostDTO;
import com.blogapplication.blogapplication.service.PostService;

import jakarta.websocket.server.PathParam;

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
    public List<Post> getAllPost(
        @RequestParam(value = "pageNo", defaultValue = "0" , required = false ) int pageNo,
        @RequestParam(value = "pageSize", defaultValue = "2" , required = false ) int pageSize
    )
    {
        return postService.getAllPost(pageNo,pageSize);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") Long postId)
    
    {
        return postService.getPostById(postId);
    }

    @PutMapping("/{id}")
    public Post updatePostById(@PathVariable("id") Long postId, @RequestBody Post post )
    {
        return postService.updatePost(postId, post);
    }

    @DeleteMapping("{id}")
    public String deletePost(@PathVariable("id") Long postId )
    {
        return postService.deletePost(postId);
    }
}
