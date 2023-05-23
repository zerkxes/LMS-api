package com.zerkxes.controller;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerkxes.entity.Users;
import com.zerkxes.exception.UserErrorResponse;
import com.zerkxes.exception.UserNotFoundException;
import com.zerkxes.service.UserService;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TransactionRequiredException;
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userv;

	@GetMapping(value = "/list/{owner}")
	public List<Users> listAllUsers(@PathVariable String owner) {
		return userv.listAllUsers(owner);
	}

	@GetMapping(value = "/findById/{id}")
	public Users findUserById(@PathVariable int id) {
		System.out.println("caught");
		return userv.findById(id);
	}

	@GetMapping(value = "/findByUser/{u_name}")
	public Users findUserByUserName(@PathVariable String u_name) {
		return userv.findByUserName(u_name);
	}

	@PostMapping(value = "/create/")
	public Users createUser(@RequestBody Users user) {
		userv.createUser(user);
		return user;
	}

	@PostMapping(value = "/update/")
	public Users updateUser(@RequestBody Users user) {
		return userv.updateUser(user);
	}

	@PostMapping(value = "/delete/{id}")
	public Users deleteUser(@PathVariable int id) {
		return userv.deleteUser(id);
	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<UserErrorResponse> handleUserNotFoundException(UserNotFoundException exp) {
		UserErrorResponse error = new UserErrorResponse(HttpStatus.NOT_FOUND.value(), exp.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler
//	public ResponseEntity<UserErrorResponse> handleAllUserFindByIdEdgeCaseException(Exception exp) {
//		UserErrorResponse error = new UserErrorResponse();
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage("Invalid Input");
//		error.setTimestamp(System.currentTimeMillis());
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}

	@ExceptionHandler({NoResultException.class, EmptyResultDataAccessException.class})
	public ResponseEntity<UserErrorResponse> handleFindByUsername( EmptyResultDataAccessException x) {
		UserErrorResponse error = new UserErrorResponse(HttpStatus.BAD_REQUEST.value(), "User not found",
				System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler({TransactionRequiredException.class, SQLIntegrityConstraintViolationException.class})
	public ResponseEntity<UserErrorResponse> handleCreateUserException(SQLIntegrityConstraintViolationException exp) {
		UserErrorResponse error = new UserErrorResponse(HttpStatus.CONFLICT.value(), "conflict with user creation. Possible duplicate entry for id or username", System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}

}
