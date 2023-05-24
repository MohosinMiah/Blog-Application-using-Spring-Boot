package com.blogapplication.blogapplication.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDto {

    private Long id;

    private String name;

    private String description;
    
}
