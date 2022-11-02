package com.task.taskRestApi.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class AuthorRequest {
    private Long id;
    @NotEmpty(message = "Author Name is Required!")
    private String authorName;
}
