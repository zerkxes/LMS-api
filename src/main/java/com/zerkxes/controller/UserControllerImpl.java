package com.zerkxes.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zerkxes.entity.Users;
import com.zerkxes.service.UserService;
@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userv;

	@Override
	public List<Users> listAllUsers(@PathVariable String owner) {
		return userv.listAllUsers(owner);
	}

	@Override
	public Users findUserById(@PathVariable int id) {
		System.out.println("caught");
		return userv.findById(id);
	}

	@Override
	public Users findUserByUserName(@PathVariable String u_name) {
		return userv.findByUserName(u_name);
	}

	@Override
	public Users createUser(@RequestBody Users user) {
		userv.createUser(user);
		return user;
	}

	@Override
	public Users updateUser(@RequestBody Users user) {
		return userv.updateUser(user);
	}

	@Override
	public Users deleteUser(@PathVariable int id) {
		return userv.deleteUser(id);
	}

}
