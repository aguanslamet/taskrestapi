package com.task.taskRestApi.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder

public class UserRequest  {
    private Long id;
    @NotEmpty(message = "fullName is Required!")
    private String fullname;
    @Email(message = "In Correte Formate Email!")
    private String email;
    @NotEmpty(message = "Password is Required!")
    private String password;
}
