package com.blogapplication.blogapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
import com.blogapplication.blogapplication.payload.PostResponse;
import com.blogapplication.blogapplication.service.PostService;
import com.blogapplication.blogapplication.utils.AppConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.media.MediaType;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/posts")
@Tag(
    name = "CRUD Rest API for Post Resource"
)
public class PostController {
    
    @Autowired
    private PostService postService;


    @SecurityRequirement(
        name = "Bear Authentication"
    )
    @Operation(
        summary  = "Create Post Rest API",
        description = "Create Rest API to save post into database"
    )
    @ApiResponse(responseCode = "201", description = "Successfully Saved Data. New post created")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public PostDTO createPost( @Validated @RequestBody PostDTO postDto)
    {
        return postService.createPost(postDto);
    }


    @SecurityRequirement(
        name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public PostResponse getAllPost(

        @RequestParam(value = "pageNo",   defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
        @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
        @RequestParam(value = "sortBy",   defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
        @RequestParam(value = "sortDir",  defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    )
    {
        return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") Long postId)  
    
    {
        return postService.getPostById(postId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public PostDTO updatePostById(@PathVariable("id") Long postId, @RequestBody PostDTO postDTO )
    {
        return postService.updatePost(postId, postDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    public String deletePost(@PathVariable("id") Long postId )
    {
        return postService.deletePost(postId);
    }

    @GetMapping("/category/{categoryId}")
    public List<PostDTO> findByCategoryId(@PathVariable("categoryId") Long categoryId )
    {
        return postService.findByCategoryId(categoryId);
    }
}
