package com.bank.sys.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.sys.dto.UserDto;
import com.bank.sys.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByusername(String username);

}
