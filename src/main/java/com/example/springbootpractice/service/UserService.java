package com.example.springbootpractice.service;

import com.example.springbootpractice.dto.request.UserRequest;
import com.example.springbootpractice.dto.response.UserResponse;
import com.example.springbootpractice.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
     UserResponse save(UserRequest userRequest);

    Page<Users> loadUsers(Pageable pageable);

    void userStatus(long id);
}
