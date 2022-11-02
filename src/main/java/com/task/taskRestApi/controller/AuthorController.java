package com.task.taskRestApi.controller;

import com.task.taskRestApi.dto.AllAuthorResponse;
import com.task.taskRestApi.dto.AuthorRequest;
import com.task.taskRestApi.dto.ResponseStatus;
import com.task.taskRestApi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthorController {
@Autowired
private AuthorService authorService;


    @PostMapping("/saveOrEditAuthor")
    public ResponseStatus saveOrEditAuthor(@Valid @RequestBody AuthorRequest request, Errors errors){
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
        return authorService.saveOrEditAuthor(request);
    }

    @DeleteMapping("/deletedataAuthor")
    public ResponseStatus deletedataAuthor(@RequestParam(defaultValue = "")Long id){
        return authorService.deletedataAuthor(id);
    }

    @GetMapping("/getAllAuthor")
    public AllAuthorResponse getAllAuthor(){
        return authorService.getAllAuthor();
    }
}
