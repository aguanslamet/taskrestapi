package com.task.taskRestApi.service;

import com.task.taskRestApi.dto.BookRequest;
import com.task.taskRestApi.dto.DetailBookResponse;
import com.task.taskRestApi.dto.GetAllBooks;
import com.task.taskRestApi.dto.ResponseStatus;
import com.task.taskRestApi.model.Author;
import com.task.taskRestApi.model.Books;
import com.task.taskRestApi.model.Publisher;
import com.task.taskRestApi.repository.AuthorRepository;
import com.task.taskRestApi.repository.BooksRepository;
import com.task.taskRestApi.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    public ResponseStatus savedataBook(BookRequest request) {
    if(request.getId()!=null){
        Books books = booksRepository.findById(request.getId()).get();
        books.setId(request.getId());
        books.setBookName(request.getBookName());
        books.setIdAuthor(request.getAuthorId());
        books.setIdPublisher(request.getPublishId());
        booksRepository.save(books);
    } else{
        Books books = new Books();
        books.setBookName(request.getBookName());
        books.setIdAuthor(request.getAuthorId());
        books.setIdPublisher(request.getPublishId());
        booksRepository.save(books);
    }
    return ResponseStatus.builder()
            .responeCode("200")
            .responseMessage("Success")
            .build();
    }
    public ResponseStatus deletedataBook(Long id) {
        Books books = booksRepository.findById(id).get();
        booksRepository.delete(books);

        return ResponseStatus.builder()
                .responeCode("200")
                .responseMessage("Success")
                .build();
    }

    public DetailBookResponse detailBookById(Long id) {
        Books books = booksRepository.findById(id).get();
        Author  author = new Author();
        if (books.getIdAuthor()!=null){
             author = authorRepository.findById(books.getIdAuthor()).get();
            }
        Publisher publisher = new Publisher();
        if (books.getIdPublisher()!=null){
             publisher = publisherRepository.findById(books.getIdPublisher()).get();
        }
            return DetailBookResponse.builder()
                    .responeCode("200")
                    .responseMessage("Success")
                    .idBook(books.getId())
                    .bookName(books.getBookName())
                    .authorBook(author.getAuthorName())
                    .publisherBook(publisher.getPublisherName())
                    .build();
    }

    public GetAllBooks getAllBooks() {
        List<Books> booksLiat = booksRepository.findAll();
        return GetAllBooks.builder()
                .responeCode("200")
                .responseMessage("Success")
                .books(booksLiat)
                .build();
    }

}
