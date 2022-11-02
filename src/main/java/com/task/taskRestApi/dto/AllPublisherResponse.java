package com.task.taskRestApi.dto;

import com.task.taskRestApi.model.Publisher;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AllPublisherResponse {
    private String responeCode;
    private String responseMessage;
    private List<GetAllPublisher> publisher;
}
