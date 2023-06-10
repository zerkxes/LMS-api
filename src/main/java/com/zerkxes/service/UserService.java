package com.zerkxes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerkxes.entity.Users;
import com.zerkxes.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	public List<Users> listAllUsers(String owner) {
		return repo.listAllUsers(owner);
	}
	
	public Users createUser(Users user) {
		repo.createUser(user);
		return user;
	}
	
	public Users updateUser(Users user) {
		repo.updateUser(user);
		return findById(user.getId());
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
