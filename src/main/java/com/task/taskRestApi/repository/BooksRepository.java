package com.task.taskRestApi.repository;

import com.task.taskRestApi.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books,Long> {
    List<Books> findByIdAuthor(Long idAuthor);

    List<Books> findByIdPublisher(Long idPublisher);
}
