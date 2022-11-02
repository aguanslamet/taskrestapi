package com.task.taskRestApi.service;

import com.task.taskRestApi.dto.AllAuthorResponse;
import com.task.taskRestApi.dto.AuthorRequest;
import com.task.taskRestApi.dto.GetAllAuthor;
import com.task.taskRestApi.dto.ResponseStatus;
import com.task.taskRestApi.model.Author;
import com.task.taskRestApi.model.Books;
import com.task.taskRestApi.repository.AuthorRepository;
import com.task.taskRestApi.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BooksRepository booksRepository;
    public ResponseStatus saveOrEditAuthor(AuthorRequest request) {
        if(request.getId()!=null){
            Author author = authorRepository.findById(request.getId()).get();
            author.setId(request.getId());
            author.setAuthorName(request.getAuthorName());
            authorRepository.save(author);
        } else{
            Author author = new Author();
            author.setAuthorName(request.getAuthorName());
            authorRepository.save(author);
        }
        return ResponseStatus.builder()
                .responeCode("200")
                .responseMessage("Success")
                .build();
    }

    public ResponseStatus deletedataAuthor(Long id) {
        Author books = authorRepository.findById(id).get();
        authorRepository.delete(books);

        return ResponseStatus.builder()
                .responeCode("200")
                .responseMessage("Success")
                .build();
    }

    public AllAuthorResponse getAllAuthor() {
       List<Author> authors = authorRepository.findAll();
       List<GetAllAuthor> getAllAuthors = new ArrayList<>();
        for (Author author :authors){
            GetAllAuthor allAuthor = new GetAllAuthor();
            allAuthor.setId(author.getId());
            allAuthor.setNama(author.getAuthorName());
            List<Books> books =booksRepository.findByIdAuthor(author.getId());
            allAuthor.setBooks(books);
            getAllAuthors.add(allAuthor);
       }
return AllAuthorResponse.builder()
        .responeCode("200")
        .responseMessage("Success")
        .author(getAllAuthors)
        .build();
    }
}
