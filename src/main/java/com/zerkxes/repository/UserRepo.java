package com.zerkxes.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zerkxes.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepo {

	@PersistenceContext
	private EntityManager eMan;

	public void createUser(Users user) {
		eMan.merge(user);
	}

	public void updateUser(Users user) {
		Users existing = findById(user.getId());
		existing.setName(user.getName());
		existing.setPswrd(user.getPswrd());
		existing.setType(user.getType());
		existing.setU_name(user.getU_name());
		eMan.merge(existing);
	}

	public List<Users> listAllUsers() {
		return (List<Users>) eMan.createQuery("select * from USERS", Users.class);
	}

	public Users findById(int id) {
		return eMan.find(Users.class, id);
	}

	public Users findByUserName(String u_name) {
		String query = "select id from USERS where u_name=:u_name";
		Users found = (Users) eMan.createQuery(query, Users.class).setParameter("u_name", u_name).getSingleResult();
		return found;
	}

	public Users deleteById(int id) {
		Users x = findById(id);
		eMan.remove(id);
		return x;
	}

}
