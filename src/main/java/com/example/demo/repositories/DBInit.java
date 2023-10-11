package com.example.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.UserEntity;

import jakarta.annotation.PostConstruct;

@Component
public class DBInit {
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	// @Transactional
	public void initializeDatabase() {
		UserEntity user = new UserEntity("John", "123456");
		
		userRepository.save(user);
	}
}
