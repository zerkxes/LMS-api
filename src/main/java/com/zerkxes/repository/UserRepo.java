package com.zerkxes.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zerkxes.entity.Users;
import com.zerkxes.exception.NotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepo {

	@PersistenceContext
	private EntityManager eMan;

	public void createUser(Users user) {
		user.setName(user.getName().trim());
		user.setU_name(user.getU_name().trim());
		eMan.merge(user);
	}

	public void updateUser(Users user) {
		Users existing = findById(user.getId());
		existing.setName(user.getName().trim());
		existing.setPswrd(user.getPswrd());
		existing.setType(user.getType());
		existing.setU_name(user.getU_name().trim());
		existing.setZ_owner(user.getZ_owner());
		eMan.merge(existing);
	}

	public List<Users> listAllUsers(String owner) {
		return eMan.createQuery("select u from Users u where u.z_owner = :owner", Users.class)
				.setParameter("owner", owner).getResultList();
	}

	public Users findById(int id) {

		if (eMan.find(Users.class, id) == null)
			throw new NotFoundException("User Not found with id : " + id);
		else
			return eMan.find(Users.class, id);
	}

	public Users findByUserName(String u_name) {
		String query = "select u from Users u where u.u_name = :userName";
		Users found = eMan.createQuery(query, Users.class).setParameter("userName", u_name).getSingleResult();
		if(found == null)
			throw new NotFoundException("No user found for given username: " + u_name);
		return found;
	}

	public Users deleteById(int id) {
		Users x = findById(id);
		eMan.remove(x);
		return x;
	}

}
