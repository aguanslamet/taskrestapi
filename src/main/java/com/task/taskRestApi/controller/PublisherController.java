package com.task.taskRestApi.controller;

import com.task.taskRestApi.dto.AllAuthorResponse;
import com.task.taskRestApi.dto.AllPublisherResponse;
import com.task.taskRestApi.dto.PublisherRequest;
import com.task.taskRestApi.dto.ResponseStatus;
import com.task.taskRestApi.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    PublisherService publisherService;


    @PostMapping("/saveOrEditPublisher")
    public ResponseStatus saveOrEditPublisher( @Valid @RequestBody PublisherRequest request,Errors errors){
        String resposnse="";
        if (errors.hasErrors()){
            for(ObjectError objectError:  errors.getAllErrors()){
                resposnse =objectError.getDefaultMessage();
            };
            return ResponseStatus.builder()
                    .responeCode("400")
                    .responseMessage(resposnse)
                    .build();
        }
        return publisherService.saveOrEditPublisher(request);
    }

    @DeleteMapping("/deletedataPublisher")
    public ResponseStatus deletedataPublisher(@RequestParam(defaultValue = "")Long id){
        return publisherService.deletedataPublisher(id);
    }

    @GetMapping("/getAllPublisher")
    public AllPublisherResponse getAllPublisher(){
        return publisherService.getAllPublisher();
    }
}
