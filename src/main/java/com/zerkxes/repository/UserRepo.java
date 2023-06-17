package com.zerkxes.repository;

import java.util.List;

import com.zerkxes.entity.Users;

public interface UserRepo {

	public Users createUser(Users user);

	public Users updateUser(Users user);

	public List<Users> listAllUsers(String owner);

	public Users findById(int id);

	public Users findByUserName(String u_name);

	public Users deleteById(int id);
}
