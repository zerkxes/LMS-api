package com.zerkxes.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TransactionRequiredException;
@ControllerAdvice
@Order(1)
public class LMSExceptionHandler {
	
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<UserErrorResponse> handleUserNotFoundException(NotFoundException exp) {
		UserErrorResponse error = new UserErrorResponse(HttpStatus.NOT_FOUND.value(), exp.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({NoResultException.class, EmptyResultDataAccessException.class})
	public ResponseEntity<UserErrorResponse> handleFindByUsername( EmptyResultDataAccessException x) {
		UserErrorResponse error = new UserErrorResponse(HttpStatus.BAD_REQUEST.value(), "Not found",
				System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler({TransactionRequiredException.class, SQLIntegrityConstraintViolationException.class})
	public ResponseEntity<UserErrorResponse> handleCreateUserException(SQLIntegrityConstraintViolationException exp) {
		UserErrorResponse error = new UserErrorResponse(HttpStatus.CONFLICT.value(), "conflict with creation. Possible duplicate entry for id or username", System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
}
