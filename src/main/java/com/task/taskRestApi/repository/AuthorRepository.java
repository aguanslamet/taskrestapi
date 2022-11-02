package com.task.taskRestApi.repository;

import com.task.taskRestApi.dto.ResponseStatus;
import com.task.taskRestApi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

}
