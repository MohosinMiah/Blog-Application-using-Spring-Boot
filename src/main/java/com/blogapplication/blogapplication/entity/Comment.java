package com.blogapplication.blogapplication.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments" )
public class Comment {
    
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private Long id;

    private String name;
    private String email;
    private String body;

    @ManyToOne()
    @JoinColumn(name = "post_id", nullable = false )
    private Post post;
}
