package com.zerkxes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerkxes.entity.Users;
import com.zerkxes.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	public Users createUser(Users user) {
		repo.createUser(user);
		return user;
	}
	
	public Users updateUser(Users user) {
		repo.updateUser(user);
		return user;
	}
	
	public Users findById(int id) {
		return repo.findById(id);
	}
	
	public Users findByUserName(String u_name) {
		return repo.findByUserName(u_name);
	}
	
	public Users deleteUser(int id) {
		return repo.deleteById(id);
	}
}
