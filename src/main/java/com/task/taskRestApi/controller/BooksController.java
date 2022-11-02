package com.task.taskRestApi.controller;

import com.task.taskRestApi.dto.BookRequest;
import com.task.taskRestApi.dto.DetailBookResponse;
import com.task.taskRestApi.dto.GetAllBooks;
import com.task.taskRestApi.dto.ResponseStatus;
import com.task.taskRestApi.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BooksController {
    @Autowired
    private BooksService booksService;

    @PostMapping("/saveOrEditDataBook")
    public ResponseStatus savedataBook(@Valid @RequestBody BookRequest request, Errors errors){
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
        return booksService.savedataBook(request);
    }

    @DeleteMapping("/deleteDataBook")
    public ResponseStatus deletedataBook(@RequestParam(defaultValue = "")Long id){
        return booksService.deletedataBook(id);
    }

    @GetMapping("/detailBookById")
    public DetailBookResponse detailBookById(@RequestParam(defaultValue = "")Long id){
        return booksService.detailBookById(id);
    }

    @GetMapping("/getAllBooks")
    public GetAllBooks getAllBooks(){
        return booksService.getAllBooks();
    }

}
