package com.ldkspringbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldkspringbase.entity.UserEntity;
import com.ldkspringbase.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService UserService;

	@PostMapping("/register")
	public ResponseEntity<Boolean> createUser(@RequestBody UserEntity userEntity) {
		return ResponseEntity.ok(UserService.createUser(userEntity));
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody UserEntity userEntity) {
		return ResponseEntity.ok(UserService.login(userEntity));
	}

}
