package com.example.springbootpractice.service;

import com.example.springbootpractice.dto.request.UserRequest;
import com.example.springbootpractice.dto.response.UserResponse;
import com.example.springbootpractice.exceptions.MyExceptions;
import com.example.springbootpractice.model.Users;
import com.example.springbootpractice.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        Optional<Users> byUsername = userRepository.findByUsername(userRequest.getUsername());
        if (byUsername.isPresent()){
            throw new MyExceptions("user.exist");
        }
        return mapUserToUserResponse(userRepository.save(mapUserRequestToUser(userRequest)));
    }

    @Override
    public Page<Users> loadUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void userStatus(long id) {
        Users users = userRepository.findById(id).orElseThrow(() ->
                new MyExceptions("user.not.found"));
       // users.setDeleted(LocalDateTime.now());
        userRepository.delete(users);
       // userRepository.save(users);
    }

    private Users mapUserRequestToUser(UserRequest userRequest) {
        return Users.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .enabled(true)
                .build();
    }

    private UserResponse mapUserToUserResponse(Users user) {
        return new UserResponse().builder()
                .userId(user.getId())
                .username(user.getUsername())
                .enabled(user.isEnabled())
                .build();
    }
}
