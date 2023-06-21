package com.zerkxes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zerkxes.entity.Users;

import jakarta.validation.Valid;

@RequestMapping("/user")
public interface UserController {

	@GetMapping(value = "/list/{owner}")
	public ResponseEntity<List<Users>> listAllUsers(@PathVariable String owner);

	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<Users> findUserById(@PathVariable int id);

	@GetMapping(value = "/findByUser/{u_name}")
	public ResponseEntity<Users> findUserByUserName(@PathVariable String u_name);

	@PostMapping(value = "/create/")
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user);

	@PostMapping(value = "/update/")
	public ResponseEntity<Users> updateUser(@Valid @RequestBody Users user);

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Users> deleteUser(@PathVariable int id);
}
