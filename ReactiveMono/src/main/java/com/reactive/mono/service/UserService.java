package com.reactive.mono.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.mono.entity.User;
import com.reactive.mono.repository.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Create or Update User
	public Mono<User> saveUser(User user) {
		return userRepository.save(user);
	}

	// Read User by ID
	public Mono<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	// Read User by Email
	public Mono<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	// Delete User by ID
	public Mono<Void> deleteUser(Long id) {
		return userRepository.deleteById(id);
	}
}
