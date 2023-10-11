package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserEntity;
import com.example.demo.exceptions.GeneralException;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity login(UserEntity user) {
		
	    try {
	        if (user.getUsername() != null && !user.getUsername().isEmpty() && user.getPassword() != null && !user.getPassword().isEmpty()) {
	        	UserEntity userFound = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

	            if (userFound != null) {
	                return userFound; // Return the user if found
	            } else {
	                throw new GeneralException("User not found"); // Custom exception for user not found
	            }
	        } else {
	            throw new IllegalArgumentException("Invalid username or password");
	        }
	    } catch (IllegalArgumentException e) {
	        // Handle invalid credentials exception here
	        // You can log it or perform any necessary actions
	        throw e; // Rethrow the exception if needed
	    } catch (GeneralException e) {
	        // Handle general exception here
	        // You can log it or perform any necessary actions
	        throw e; // Rethrow the exception if needed
	    }
	}

	@Override
	public void register(String username, String password) {
		UserEntity user = new UserEntity();
		if (!username.isEmpty() && username != null) {
			user.setUsername(username);
			user.setPassword(password);
			userRepository.save(user);
		}
	}

}
