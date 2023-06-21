package com.zerkxes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zerkxes.entity.Users;
import com.zerkxes.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userv;

	@Override
	public ResponseEntity<List<Users>> listAllUsers(@PathVariable String owner) {
		return new ResponseEntity<>(userv.listAllUsers(owner), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Users> findUserById(@PathVariable int id) {
		System.out.println("caught");
		return new ResponseEntity<>(userv.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Users> findUserByUserName(@PathVariable String u_name) {
		return new ResponseEntity<>(userv.findByUserName(u_name), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		userv.createUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Users> updateUser(@Valid @RequestBody Users user) {
		return new ResponseEntity<>(userv.updateUser(user), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Users> deleteUser(@PathVariable int id) {
		return new ResponseEntity<>(userv.deleteUser(id), HttpStatus.OK);
	}

}
