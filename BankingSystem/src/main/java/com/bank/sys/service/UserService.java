package com.bank.sys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sys.dto.UserDto;
import com.bank.sys.entity.Account;
import com.bank.sys.entity.User;
import com.bank.sys.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo ur;
	
	private UserDto convertToDTO(User user) {
//		List<Integer> accountIds = new ArrayList<>();
//		for(Account account : user.getAccounts())
//		{
//			accountIds.add(account.getAccountid());
//		}
		UserDto newusdto = new UserDto(user.getId(),user.getUsername(),user.getEmail(),user.getUserType());
		return newusdto;
	}

	public UserDto registerUser(User user) {
	    // Save the user in the database
	    User savedUser = ur.save(user);  // Assuming ur is your UserRepository

	    // Map the saved user to a UserDto
	    UserDto dto = new UserDto();
	    dto.setEmail(savedUser.getEmail());
	    dto.setUsername(savedUser.getUsername());
	    dto.setUserType(savedUser.getUserType());
	    dto.setId(savedUser.getId());

	    return dto;
	}

	public String loginUser(String username,String password) {
		Optional<User> excistinguser = ur.findByusername(username);
		if(excistinguser.isPresent())
		{
			if(excistinguser.get().getPassword().equals(password))
			{
				return "login success";
			}
			else
			{
				return "password mismatch";
			}
		} 
		else
		{
			return "user not found";
		}
	}

	public List<UserDto> getAllUsers() {
		List<User> users = ur.findAll();
		List<UserDto> userdtos = new ArrayList<>();
		for(User user: users)
		{
			UserDto dto = convertToDTO(user);
			userdtos.add(dto);
		}
		return userdtos;
	}

	public UserDto updateUser(String email, UserDto userDTO) {
		
	}

		

}
