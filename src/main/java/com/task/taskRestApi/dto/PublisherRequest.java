package com.task.taskRestApi.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class PublisherRequest {
    private Long id;
    @NotEmpty(message = "pubilsher Name is Required!")
    private String publisherName;
}
