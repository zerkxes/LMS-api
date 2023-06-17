package com.zerkxes;

import static org.junit.Assert.assertEquals;
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

import com.zerkxes.controller.UserControllerImpl;
import com.zerkxes.entity.Users;
import com.zerkxes.entity.Users.role;
import com.zerkxes.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@Mock
	private UserService uServMock;
	@InjectMocks
	private UserControllerImpl userController;

	@BeforeEach
	void setup() {
		Users u1=new Users(1, "Aniket", "zerkxes", "abcd1234", role.Librarian, "something", null);
	}

	@Test
	void test_ListAllUsers_ShouldReturn_When_OwnerIsValid() {
		// given
		List<Users> expected = new ArrayList<>(List.of(new Users(), new Users()));
		when(uServMock.listAllUsers("aniket")).thenReturn(expected);
		// when
		List<Users> actual = userController.listAllUsers("aniket");
		// then
		assertEquals(expected, actual);
	}

	@Test
	void test_ListAllUsers_ShouldEmptyArray_When_OwnerIsInvalid() {
		// given
		// Users u1=new Users(1, "Aniket", "zerkxes", "abcd1234", role.Librarian,
		// "something", null);
		List<Users> expected = Collections.emptyList();
		when(uServMock.listAllUsers("aniket")).thenReturn(expected);
		// when
		List<Users> actual = userController.listAllUsers("aniket");
		// then
		assertEquals(expected, actual);
	}
}
