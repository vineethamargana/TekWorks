package com.bank.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.sys.dto.LoginRequestDto;
import com.bank.sys.dto.UserDto;
import com.bank.sys.entity.User;
import com.bank.sys.service.UserService;

@RestController
@RequestMapping("/api/banksys/users")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody User user) 
	{
		UserDto created = us.registerUser(user);
	    return new ResponseEntity<>(created,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginRequestDto loginRequest) 
	{
	        String s = us.loginUser(loginRequest.getUsername(),loginRequest.getPassword());
	        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
    }

	 // Get all users
    @GetMapping("/getallUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = us.getAllUsers();
        return ResponseEntity.ok(users);
    }

	    // Update a user
	    @PutMapping("/update/{email}")
	    public ResponseEntity<UserDto> updateUser(@PathVariable String email, @RequestBody UserDto userDTO) {
	        UserDto updatedUser = us.updateUser(email, userDTO);
	        if (updatedUser != null) {
	            return ResponseEntity.ok(updatedUser);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

//	    // Delete a user by ID
//	    @DeleteMapping("/delete/{id}")
//	    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//	        userService.deleteUser(id);
//	        return ResponseEntity.noContent().build();
//	    }
//	
}
