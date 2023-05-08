package com.blogapplication.blogapplication.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "posts", uniqueConstraints = {@UniqueConstraint( columnNames = {"title"} ) }
)
public class Post {
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private Long Id;

    
    @Column( name = "title", nullable = false)
    private String title;

    @Column( name = "description", nullable = false)
    private String description;

    @Column( name = "content", nullable = false)
    private String content;
}
