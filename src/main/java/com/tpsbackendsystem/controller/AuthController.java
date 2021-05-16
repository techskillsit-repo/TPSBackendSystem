package com.tpsbackendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tpsbackendsystem.model.User;
import com.tpsbackendsystem.repository.UserRepository;

@RestController
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passEncoder;
	@PostMapping("/user")
	public User postUser(@RequestBody User user) {
		user.setPassword(passEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
