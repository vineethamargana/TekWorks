package com.bank.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.sys.dto.UserDTO;
import com.bank.sys.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

//	UserDTO findByuserId(Long userId);
}