package com.blogapplication.blogapplication.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.blogapplication.blogapplication.entity.Post;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private List<Post> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
