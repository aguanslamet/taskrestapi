package com.task.taskRestApi.repository;

import com.task.taskRestApi.dto.UsersDto;
import com.task.taskRestApi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<Users,Long> {

    Optional<Users> findByEmail(String email);
}
