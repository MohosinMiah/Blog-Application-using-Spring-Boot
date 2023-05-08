package com.blogapplication.blogapplication.payload;

import lombok.Data;

@Data
public class PostDTO {
    private Long Id;
    private String title;
    private String description;
    private String content;
}
