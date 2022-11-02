package com.task.taskRestApi.controller;

import com.task.taskRestApi.dto.ResponseRegister;
import com.task.taskRestApi.dto.ResponseStatus;
import com.task.taskRestApi.dto.UserRequest;
import com.task.taskRestApi.service.RestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestApiController {
    @Autowired
    private RestApiService restApiService;

    @PostMapping("/register")
    private ResponseStatus register(@Valid @RequestBody UserRequest request, Errors errors){
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
        return restApiService.register(request);
    }
}
