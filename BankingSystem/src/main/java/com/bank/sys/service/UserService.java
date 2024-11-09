package com.bank.sys.service;

import com.bank.sys.dto.UserDto;

import com.bank.sys.entity.User;
import com.bank.sys.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public UserDto createUser(User user1) {
        User user = new User(user1.getUsername(), null, user1.getUserType(), user1.getEmail());
        User savedUser = userRepository.save(user);
        return new UserDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(), savedUser.getUserType());
    }

    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getUserType());
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(u -> new UserDto(u.getId(), u.getUsername(), u.getEmail(), u.getUserType())).collect(Collectors.toList());
    }

    public UserDto updateUser(int id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setUserType(userDto.getUserType());
        User updatedUser = userRepository.save(user);
        return new UserDto(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getEmail(), updatedUser.getUserType());
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
