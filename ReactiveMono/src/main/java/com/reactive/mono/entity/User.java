package com.reactive.mono.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long id;
    private String name;
    private String email;

    // Getters and Setters
}
