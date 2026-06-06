package com.example.springbootpractice.service;

import com.example.springbootpractice.dto.request.UserRequest;
import com.example.springbootpractice.dto.response.UserResponse;

public interface UserService {
     UserResponse save(UserRequest userRequest);
}
