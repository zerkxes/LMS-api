package com.zerkxes.test.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zerkxes.entity.Users;
import com.zerkxes.entity.Users.role;
import com.zerkxes.exception.NotFoundException;
import com.zerkxes.repository.UserRepo;
import com.zerkxes.service.UserServiceImpl;

import jakarta.validation.ConstraintViolationException;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private Users user;
	@Mock
	private UserRepo repoMock;
	@InjectMocks
	private UserServiceImpl userv;

	@Before
	void setup() {
		Users user = new Users();
		user.setId(1);
		user.setName("Aniket");
		user.setU_name("zerkxes");
		user.setPswrd("abcd1234");
		user.setType(role.Librarian);
		user.setZ_owner("aniket");
		user.setBook(null);
	}

	@Test
	void test_ListAllUsers_ShouldReturnTrue_WhenUsersExist() {
		// given
		List<Users> expected = Arrays.asList(user);
		when(repoMock.listAllUsers("aniket")).thenReturn(expected);
		// when
		List<Users> actual = userv.listAllUsers("aniket");
		// then
		assertEquals(expected, actual);
	}

	@Test
	void test_ListAllUsers_ShouldReturnEmptyList_When_ListEmpty() {
		// given
		when(repoMock.listAllUsers("aniket")).thenReturn(Collections.emptyList());
		// when
		List<Users> actual = userv.listAllUsers("aniket");
		// then
		assertEquals(Collections.emptyList(), actual);
	}

	@Test
	void test_CreateUser_ShouldSaveUser_When_UserValid() {
		// given
		when(repoMock.createUser(user)).thenReturn(user);
		// when
		userv.createUser(user);
		// then
		verify(repoMock, times(1)).createUser(user);
	}

	@Test
	void test_CreateUser_ShouldThrowError_When_UserInvalid() {
		// given
		user.setId(-11);
		when(repoMock.createUser(user)).thenThrow(ConstraintViolationException.class);
		// when

		// then
		assertThrows(ConstraintViolationException.class, () -> userv.createUser(user));
	}

	@Test
	void test_UpdateUser_ShouldUpdate_When_UserValid() {
		// given
		when(repoMock.updateUser(user)).thenReturn(user);
		// when
		userv.updateUser(user);
		// then
		verify(repoMock, times(1)).updateUser(user);
	}

	@Test
	void test_FindById_ShouldReturn_When_IdValid() {
		// given
		when(repoMock.findById(1)).thenReturn(user);
		// when
		Users actual = userv.findById(1);
		// then
		assertEquals(user, actual);
	}

	@Test
	void test_FindById_ShouldReturn_When_IdInvalid() {
		// given
		when(repoMock.findById(-11)).thenThrow(NotFoundException.class);
		// when
		// then
		assertThrows(NotFoundException.class, () -> userv.findById(-11));
	}

	@Test
	void test_FindByUsername_ShouldReturn_When_UsernameValid() {
		// given
		when(repoMock.findByUserName("zerkxes")).thenReturn(user);
		// when
		Users actual = userv.findByUserName("zerkxes");
		// then
		assertEquals(user, actual);
	}
	
	@Test
	void test_FindByUsername_ShouldThrowError_When_UsernameInvalid() {
		// given
		when(repoMock.findByUserName("zerk")).thenThrow(NotFoundException.class);
		// when
		// then
		assertThrows(NotFoundException.class, () -> userv.findByUserName("zerk"));
	}
	
	@Test
	void test_DeleteById_ShouldDelete_When_IdValid() {
		// given
		when(repoMock.deleteById(1)).thenReturn(user);
		// when
		userv.deleteUser(1);
		// then
		verify(repoMock, times(1)).deleteById(1);
	}
	
	@Test
	void test_DeleteById_ShouldThrowError_When_IdInvalid() {
		// given
		when(repoMock.deleteById(-11)).thenThrow(NotFoundException.class);
		// when
		// then
		assertThrows(NotFoundException.class, () -> userv.deleteUser(-11));
	}

}
