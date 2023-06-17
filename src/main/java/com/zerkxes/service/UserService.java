package com.zerkxes.service;

import java.util.List;

import com.zerkxes.entity.Users;

public interface UserService {

	public List<Users> listAllUsers(String owner);

	public Users createUser(Users user);

	public Users updateUser(Users user);

	public Users findById(int id);

	public Users findByUserName(String u_name);

	public Users deleteUser(int id);
}
