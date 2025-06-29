package com.drk.software.investmentaggregator.service;

import com.drk.software.investmentaggregator.dto.CreateUserDto;
import com.drk.software.investmentaggregator.dto.UserResponseDto;
import com.drk.software.investmentaggregator.entity.User;
import com.drk.software.investmentaggregator.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto) {
        User entity = new User(
                null,
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                null,
                null
        );

        User savedUser = userRepository.save(entity); // ✅ Save the user
        return savedUser.getUsernameId();
    }

    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(
                user -> new UserResponseDto(
                        user.getUsernameId(),
                        user.getNameUser(),
                        user.getEmailUser()
                )
        ).collect(Collectors.toList());
    }
}
