package com.example.demo.services;

import com.example.demo.entities.UserEntity;

public interface UserService {
	UserEntity login(UserEntity user);
	
	void register(String username, String password);
}
