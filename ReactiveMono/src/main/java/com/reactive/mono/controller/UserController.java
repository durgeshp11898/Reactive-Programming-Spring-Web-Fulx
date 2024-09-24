package com.reactive.mono.controller;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.reactive.mono.entity.User;
import com.reactive.mono.service.UserService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "User management APIs using reactive CRUD operations")
public class UserController {

	@Autowired
	private UserService userService;

	@Operation(summary = "Create a new user", description = "Creates a new user in the system")
	@PostMapping
	public Mono<ResponseEntity<User>> createUser(@RequestBody User user) {
		return userService.saveUser(user)
				.map(ResponseEntity::ok);
	}

	@Operation(summary = "Get a user by ID", description = "Retrieves a user by their ID")
	@GetMapping("/{id}")
	public Mono<ResponseEntity<User>> getUserById(@PathVariable Long id) {
		return userService.getUserById(id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@Operation(summary = "Delete a user by ID", description = "Deletes a user by their ID")
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id)
				.then(Mono.just(ResponseEntity.ok().build()));
	}
	
    // Get User by Email
    @GetMapping("/email/{email}")
	@Operation(summary = "Get a user by Email", description = "Retrieves a user by their Email")
    public Mono<ResponseEntity<User>> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    
}
