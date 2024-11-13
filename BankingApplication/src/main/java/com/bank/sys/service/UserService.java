package com.bank.sys.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sys.dto.UserDTO;
import com.bank.sys.entity.User;
import com.bank.sys.exceptions.AccountNotFoundException;
import com.bank.sys.repository.AccountRepository;
import com.bank.sys.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	 AccountRepository ar;
	
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) 
    {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhn(userDTO.getPhn());
        user = userRepository.save(user);
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll(); // fetching all users

        //Create an empty list to store the UserDTOs
        List<UserDTO> userDTOs = new ArrayList<>();

        // go through each user and convert it to UserDTO
        for (User user : users) {
            UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getEmail());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }
    
    
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("User not found"));
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhn());
    }
    
    
    public boolean deleteUser(Long id) {
        if (!(userRepository.findById(id)!= null)) {
            throw new AccountNotFoundException("User not found");
        }
        userRepository.deleteById(id);
        return true;   
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("User not found"));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhn(userDTO.getPhn());
      //  user.setAccounts(userDTO.getAccounts());
        userRepository.save(user);
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhn());
    }

}