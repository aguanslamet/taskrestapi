package com.task.taskRestApi.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class DetailBookResponse {
    private String responeCode;
    private String responseMessage;
    private Long idBook;
    private String bookName;
    private String authorBook;
    private String publisherBook;
}
