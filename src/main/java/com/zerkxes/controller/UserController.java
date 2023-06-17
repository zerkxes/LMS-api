package com.zerkxes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zerkxes.entity.Users;

@RequestMapping("/user")
public interface UserController {

	@GetMapping(value = "/list/{owner}")
	public List<Users> listAllUsers(@PathVariable String owner);

	@GetMapping(value = "/findById/{id}")
	public Users findUserById(@PathVariable int id);

	@GetMapping(value = "/findByUser/{u_name}")
	public Users findUserByUserName(@PathVariable String u_name);

	@PostMapping(value = "/create/")
	public Users createUser(@RequestBody Users user);

	@PostMapping(value = "/update/")
	public Users updateUser(@RequestBody Users user);

	@DeleteMapping(value = "/delete/{id}")
	public Users deleteUser(@PathVariable int id);
}
