package com.task.taskRestApi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ResponseRegister {
    private String responeCode;
    private List<String> responseMessage;
}
