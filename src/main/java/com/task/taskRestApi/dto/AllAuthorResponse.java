package com.task.taskRestApi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AllAuthorResponse {
    private String responeCode;
    private String responseMessage;
    private List<GetAllAuthor> author;
}
