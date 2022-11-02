package com.task.taskRestApi.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class BookRequest {
    private Long id;
    @NotEmpty(message = "Book Name is Required!")
    private String bookName;
    private Long authorId;
    private Long publishId;
}
