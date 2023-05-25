package com.blogapplication.blogapplication.service.impl;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.entity.Category;
import com.blogapplication.blogapplication.entity.Post;
import com.blogapplication.blogapplication.exception.BlogAPIException;
import com.blogapplication.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.blogapplication.payload.PostDTO;
import com.blogapplication.blogapplication.payload.PostResponse;
import com.blogapplication.blogapplication.repository.CategoryRepository;
import com.blogapplication.blogapplication.repository.PostRepository;
import com.blogapplication.blogapplication.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;



@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PostDTO createPost(PostDTO postDto) {
        // Create a new post
        // Get category object
        Category category = categoryRepository.findById(postDto.getCategoryId()).orElseThrow( () -> new ResourceNotFoundException("Post Resource", "Post ID", postDto.getCategoryId()));

        Post post = modelMapper.map(postDto, Post.class);
        post.setCategory(category);
        postRepository.save(post);

        // Convert entity to dto
        PostDTO responsePostDto = modelMapper.map(post, PostDTO.class);
        return responsePostDto;
    }



    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {

        // Add Pagination
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Post> paginatedPosts = postRepository.findAll(pageable);
        
        List<Post> posts = paginatedPosts.getContent();

        // Response in a proper pagination formate
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(posts);
        postResponse.setPageNo(paginatedPosts.getNumber());
        postResponse.setPageSize(paginatedPosts.getSize());
        postResponse.setTotalElements(paginatedPosts.getTotalElements());
        postResponse.setTotalPages(paginatedPosts.getTotalPages());
        postResponse.setLast(paginatedPosts.isLast());


        return postResponse;
    }



    @Override
    public Post getPostById(Long postId) {
        // TODO Auto-generated method stub
        return postRepository.findById(postId).orElseThrow(()-> new BlogAPIException(HttpStatus.BAD_REQUEST, "Blog is not available"));
    }



    @Override
    public Post updatePost(Long blogId, Post post) {
        // TODO Auto-generated method stub
        Post postGet = postRepository.findById(blogId).get();

        if( Objects.nonNull( post.getTitle() ) && !"".equalsIgnoreCase( postGet.getTitle() ))
        {
            postGet.setTitle(post.getTitle());
        }

        if( Objects.nonNull( post.getDescription() ) && !"".equalsIgnoreCase(postGet.getDescription()))
        {
            postGet.setDescription(post.getDescription());
        } 

        if( Objects.nonNull( post.getDescription() ) && !"".equalsIgnoreCase(postGet.getContent()))
        {
            postGet.setDescription(post.getDescription());
        } 
        return postRepository.save(postGet);
    }



    @Override
    public String deletePost(Long postId) {
        // TODO Auto-generated method stub
        postRepository.deleteById(postId);
        return "Post Deleted Successfully";
    }
    
}
