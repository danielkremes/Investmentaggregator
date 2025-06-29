package com.drk.software.investmentaggregator.controller;

import com.drk.software.investmentaggregator.dto.CreateUserDto;
import com.drk.software.investmentaggregator.dto.UserResponseDto;
import com.drk.software.investmentaggregator.entity.User;
import com.drk.software.investmentaggregator.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDto> readUser() {
        return userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto createUserDto){
        UUID userID = userService.createUser(createUserDto);
        return ResponseEntity.created(URI.create("/v1/users/" + userID)).build();
    }

}
