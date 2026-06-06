package com.example.springbootpractice.controller;

import com.example.springbootpractice.dto.request.UserRequest;
import com.example.springbootpractice.dto.response.UserResponse;
import com.example.springbootpractice.model.Users;
import com.example.springbootpractice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("save")
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest)  {
        return ResponseEntity.ok(userService.save(userRequest));
    }

    @GetMapping("/show")
    public ResponseEntity<Page<Users>> showUsers(Pageable pageable){
      return ResponseEntity.ok(userService.loadUsers(pageable));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> disableUser(@PathVariable long id){
        userService.userStatus(id);
        return ResponseEntity.ok().build();
    }
}
