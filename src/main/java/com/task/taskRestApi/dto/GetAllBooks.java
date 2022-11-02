package com.task.taskRestApi.dto;

import com.task.taskRestApi.model.Books;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllBooks {
    private String responeCode;
    private String responseMessage;
    private List<Books> books;
}
