package com.task.taskRestApi.dto;

import com.task.taskRestApi.model.Books;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPublisher {
    private Long id;
    private String nama;
    private List<Books> books;
}
