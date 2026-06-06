package com.example.springbootpractice.service;

import com.example.springbootpractice.dto.request.UserRequest;
import com.example.springbootpractice.dto.response.UserResponse;
import com.example.springbootpractice.model.User;
import com.example.springbootpractice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        User save = userRepository.save(mapUserRequestToUser(userRequest));
        UserResponse userResponse = mapUserToUserResponse(save);
        return userResponse;
    }

    private User mapUserRequestToUser(UserRequest userRequest){
        return   User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .enabled(true)
                .build();
    }

    private UserResponse mapUserToUserResponse(User user){
        return  new UserResponse().builder()
                .userId(user.getId())
                .username(user.getUsername())
                .enabled(user.isEnabled())
                .build();
    }
}
