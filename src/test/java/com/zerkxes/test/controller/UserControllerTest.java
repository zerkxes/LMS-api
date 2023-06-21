package com.zerkxes.test.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.zerkxes.controller.UserControllerImpl;
import com.zerkxes.entity.Users;
import com.zerkxes.entity.Users.role;
import com.zerkxes.exception.NotFoundException;
import com.zerkxes.service.UserService;

import jakarta.validation.ConstraintViolationException;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@Mock
	private UserService uServMock;
	@Mock
	private Users u1;
	@InjectMocks
	private UserControllerImpl userController;

	@BeforeEach
	void setup() {
		u1 = new Users(1, "Aniket", "zerkxes", "abcd1234", role.Librarian, "something", null);
	}

	@Test
	void test_ListAllUsers_ShouldReturn_When_OwnerIsValid() {
		// given
		List<Users> expected = new ArrayList<>(List.of(new Users(), new Users()));
		when(uServMock.listAllUsers("aniket")).thenReturn(expected);
		// when
		ResponseEntity<List<Users>> actual = userController.listAllUsers("aniket");
		// then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual.getBody());
	}

	@Test
	void test_ListAllUsers_ShouldReturnEmptyArray_When_OwnerIsInvalid() {
		// given
		List<Users> expected = Collections.emptyList();
		when(uServMock.listAllUsers("aniket")).thenReturn(expected);
		// when
		ResponseEntity<List<Users>> actual = userController.listAllUsers("aniket");
		// then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual.getBody());
	}

	@Test
	void test_FindUsersById_ShouldReturn_When_IdValid() {
		// given
		Users expected = u1;
		when(uServMock.findById(1)).thenReturn(u1);
		// when
		ResponseEntity<Users> actual = userController.findUserById(1);
		// then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual.getBody());
	}
	
	@Test
	void test_FindUsersById_ShouldThrowError_When_IdInvalid() {
		// given
		when(uServMock.findById(-11)).thenThrow(NotFoundException.class);
		// when
		// then
		assertThrows(NotFoundException.class, () -> userController.findUserById(-11));
	}
	
	@Test
	void test_FindUsersByUserName_ShouldReturn_When_UsernameValid() {
		// given
		Users expected = u1;
		when(uServMock.findByUserName("zerkxes")).thenReturn(u1);
		// when
		ResponseEntity<Users> actual = userController.findUserByUserName("zerkxes");
		// then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual.getBody());
	}
	
	@Test
	void test_FindUsersByUserName_ShouldThrowError_When_UserNameInvalid() {
		// given
		when(uServMock.findByUserName("zerk")).thenThrow(NotFoundException.class);
		// when
		// then
		assertThrows(NotFoundException.class, () -> userController.findUserByUserName("zerk"));
	}
	
	@Test
	void test_CreateUser_ShouldReturn_When_UserValid() {
		// given
		Users expected = u1;
		when(uServMock.createUser(u1)).thenReturn(u1);
		// when
		ResponseEntity<Users> actual = userController.createUser(u1);
		// then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual.getBody());
	}
	
	@Test
	void test_CreateUser_ShouldThrowError_When_UserInValid() {
		// given
		u1.setId(-11);
		Users expected = u1;
		when(uServMock.createUser(expected)).thenThrow(ConstraintViolationException.class);
		// when
		// then
		assertThrows(ConstraintViolationException.class, () -> userController.createUser(expected));
	}
	
	@Test
	void test_UpdateUser_ShouldReturn_When_UserValid() {
		// given
		Users expected = u1;
		expected.setId(2);
		when(uServMock.updateUser(expected)).thenReturn(expected);
		// when
		ResponseEntity<Users> actual = userController.updateUser(expected);
		// then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual.getBody());
	}
	
	@Test
	void test_UpdateUser_ShouldThrowError_When_UserInValid() {
		// given
		Users expected = u1;
		expected.setId(-11);
		when(uServMock.updateUser(expected)).thenThrow(ConstraintViolationException.class);
		// when
		// then
		assertThrows(ConstraintViolationException.class, () -> userController.updateUser(expected));
	}
	
	@Test
	void test_DeleteUser_ShouldReturn_When_IdValid() {
		// given
		Users expected = u1;
		when(uServMock.deleteUser(1)).thenReturn(expected);
		// when
		ResponseEntity<Users> actual = userController.deleteUser(1);
		// then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual.getBody());
	}
	
	@Test
	void test_DeleteUser_ShouldThrowError_When_IdInValid() {
		// given
		when(uServMock.deleteUser(-11)).thenThrow(NotFoundException.class);
		// when
		// then
		assertThrows(NotFoundException.class, () -> userController.deleteUser(-11));
	}
}
