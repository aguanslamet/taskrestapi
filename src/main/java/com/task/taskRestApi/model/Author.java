package com.task.taskRestApi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author_name")
    private String authorName;

}
