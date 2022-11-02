package com.task.taskRestApi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.taskRestApi.dto.ResponseRegister;
import com.task.taskRestApi.dto.ResponseStatus;
import com.task.taskRestApi.dto.UserRequest;
import com.task.taskRestApi.dto.UsersDto;
import com.task.taskRestApi.model.Users;
import com.task.taskRestApi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
@Transactional
public class RestApiService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format("")));
    }
    public ResponseStatus register(UserRequest request) {
        boolean userExsist = userRepository.findByEmail(request.getEmail()).isPresent();
        if (userExsist){
            throw new RuntimeException( String.format("User with Email '%s' already",request.getEmail()));
        }
        Users users = new Users();
        String encode = bCryptPasswordEncoder.encode(request.getPassword());
        users.setPassword(encode);
        users.setEmail(request.getEmail());
        users.setFullname(request.getFullname());
        userRepository.save(users);

        return ResponseStatus.builder()
                .responeCode("200")
                .responseMessage("Success")
                .build();
    }

}
