package com.blogapplication.blogapplication.entity;

import java.util.List;

import com.blogapplication.blogapplication.exception.ResourceNotFoundException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Post> posts;

    public Category orElseThrow(ResourceNotFoundException resourceNotFoundException) {
        return null;
    }

}
