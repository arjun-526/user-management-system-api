package com.valmiki.user.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valmiki.user.api.model.User;
import com.valmiki.user.api.service.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {

		return service.createUser(user);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User user = null;
		user = service.getUserById(id);
		return ResponseEntity.ok(user);

	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") Long id) {
		boolean deleted = false;
		deleted = service.deleteUser(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted ", deleted);
		return ResponseEntity.ok(response);

	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		user = service.updateUser(id, user);
		return ResponseEntity.ok(user);

	}
}
