package com.zerkxes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerkxes.entity.Users;
import com.zerkxes.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userv;
	
	@GetMapping(value="/list/{owner}")
	public List<Users> listAllUsers(@PathVariable String owner) {
		return userv.listAllUsers(owner);
	}
	
	@GetMapping(value="/findById/{id}")
	public Users findUserById(@PathVariable int id) {
		return userv.findById(id);
	}
	
	@GetMapping(value="/findByUser/{u_name}")
	public Users findUserByUserName(@PathVariable String u_name) {
		return userv.findByUserName(u_name);
	}
	
	
	@PostMapping(value="/create/")
	public Users createUser(@RequestBody Users user) {
		userv.createUser(user);
		return user;
	}
	
	@PostMapping(value="/update/{id}")
	public Users updateUser(@RequestBody Users user,@PathVariable int id) {
		return userv.updateUser(user);
	}
	
	@PostMapping(value="/delete/{id}")
	public Users deleteUser(@PathVariable int id) {
		return userv.deleteUser(id);
	}
	
}
