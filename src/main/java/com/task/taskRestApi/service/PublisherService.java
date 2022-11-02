package com.task.taskRestApi.service;

import com.task.taskRestApi.dto.*;
import com.task.taskRestApi.model.Author;
import com.task.taskRestApi.model.Books;
import com.task.taskRestApi.model.Publisher;
import com.task.taskRestApi.repository.BooksRepository;
import com.task.taskRestApi.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BooksRepository booksRepository;
    public ResponseStatus saveOrEditPublisher(PublisherRequest request) {
        if(request.getId()!=null){
            Publisher publisher = publisherRepository.findById(request.getId()).get();
            publisher.setId(request.getId());
            publisher.setPublisherName(request.getPublisherName());
            publisherRepository.save(publisher);
        } else{
            Publisher publisher = new Publisher();
            publisher.setPublisherName(request.getPublisherName());
            publisherRepository.save(publisher);
        }
        return ResponseStatus.builder()
                .responeCode("200")
                .responseMessage("Success")
                .build();
    }

    public ResponseStatus deletedataPublisher(Long id) {
        Publisher publisher = publisherRepository.findById(id).get();
        publisherRepository.delete(publisher);

        return ResponseStatus.builder()
                .responeCode("200")
                .responseMessage("Success")
                .build();
    }

    public AllPublisherResponse getAllPublisher() {
        List<Publisher> publishers = publisherRepository.findAll();
        List<GetAllPublisher> getAllPublishers = new ArrayList<>();
        for (Publisher publish :publishers){
            GetAllPublisher getAllAuthor = new GetAllPublisher();
            getAllAuthor.setId(publish.getId());
            getAllAuthor.setNama(publish.getPublisherName());
            List<Books> books =booksRepository.findByIdPublisher(publish.getId());
            getAllAuthor.setBooks(books);
            getAllPublishers.add(getAllAuthor);
        }
        return AllPublisherResponse.builder()
                .responeCode("200")
                .responseMessage("Success")
                .publisher(getAllPublishers)
                .build();

    }
}
