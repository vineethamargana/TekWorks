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

import com.bank.sys.dto.ApiResponse;
import com.bank.sys.dto.UserDTO;
import com.bank.sys.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<ApiResponse<UserDTO>> createUser(@RequestBody UserDTO userDTO) {
		UserDTO dto = userService.createUser(userDTO);
		ApiResponse<UserDTO> respone = new ApiResponse<UserDTO>("user created successfully", dto);
		return new ResponseEntity<ApiResponse<UserDTO>>(respone, HttpStatus.CREATED);
	}

	@GetMapping("/getAllusers")
	public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {
		List<UserDTO> users = userService.getAllUsers();
		ApiResponse<List<UserDTO>> response = new ApiResponse<List<UserDTO>>("List of users", users);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<ApiResponse<UserDTO>> findUserById(@PathVariable Long id) {
		UserDTO dto = userService.findUserById(id);
		ApiResponse<UserDTO> response = new ApiResponse<UserDTO>("The user with the corresponding id:", dto);
		return new ResponseEntity<ApiResponse<UserDTO>>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse<Boolean>> deleteUser(@PathVariable Long id) {
		Boolean deleted = userService.deleteUser(id);
		ApiResponse<Boolean> response = new ApiResponse<Boolean>("Deleted Successfully", deleted);
		return new ResponseEntity<ApiResponse<Boolean>>(response, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse<UserDTO>> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		UserDTO updated = userService.updateUser(id, userDTO);
		ApiResponse<UserDTO> response = new ApiResponse<UserDTO>("Upated Successfully", updated);
		return new ResponseEntity<ApiResponse<UserDTO>>(response, HttpStatus.OK);
	}
}
