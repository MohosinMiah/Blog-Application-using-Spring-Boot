package com.blogapplication.blogapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "roles"
)
public class Role {
    
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private Long Id;

    @Column( nullable = false )
    private String name;
}
