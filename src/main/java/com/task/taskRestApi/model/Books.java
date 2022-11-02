package com.task.taskRestApi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "id_author")
    private Long idAuthor;

    @Column(name = "id_publisher")
    private Long idPublisher;
}
