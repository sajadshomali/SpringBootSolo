package com.example.springbootpractice.service;

import com.example.springbootpractice.dto.request.UserRequest;
import com.example.springbootpractice.dto.response.UserResponse;
import com.example.springbootpractice.exceptions.MyExceptions;
import com.example.springbootpractice.model.users;
import com.example.springbootpractice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        Optional<users> byUsername = userRepository.findByUsername(userRequest.getUsername());
        if (byUsername.isPresent()){
            throw new MyExceptions("user.exist");
        }
        return mapUserToUserResponse(userRepository.save(mapUserRequestToUser(userRequest)));
    }

    private users mapUserRequestToUser(UserRequest userRequest) {
        return users.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .enabled(true)
                .build();
    }

    private UserResponse mapUserToUserResponse(users user) {
        return new UserResponse().builder()
                .userId(user.getId())
                .username(user.getUsername())
                .enabled(user.isEnabled())
                .build();
    }
}
