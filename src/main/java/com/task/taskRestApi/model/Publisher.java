package com.task.taskRestApi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "publisher_name")
    private String publisherName;
}
