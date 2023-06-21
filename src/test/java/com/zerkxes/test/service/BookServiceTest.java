package com.zerkxes.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
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

import com.zerkxes.entity.Books;
import com.zerkxes.exception.NotFoundException;
import com.zerkxes.repository.BooksRepo;
import com.zerkxes.service.BookServiceImpl;

import jakarta.validation.ConstraintViolationException;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

	@Mock
	private BooksRepo repoMock;
	@InjectMocks
	private BookServiceImpl bserv;
	private Books book;

	@BeforeEach
	void setup() {
		book = new Books(1, "LOTR", null, "aniket", null, null);
	}

	@Test
	void test_ListAllBooks_ShouldReturnList_WhenBooksExist() {
		// given
		List<Books> expected=new ArrayList<>(List.of(book));
		when(repoMock.listAllBooks()).thenReturn(expected);
		//when
		List<Books> actual=bserv.listAllBooks();
		//then
		assertEquals(expected, actual);
	}
	@Test
	void test_ListAllBooks_ShouldReturnEmptyArray_WhenEmpty() {
		// given
		//List<Books> expected=new ArrayList<>(List.of(book));
		when(repoMock.listAllBooks()).thenReturn(Collections.emptyList());
		//when
		List<Books> actual=bserv.listAllBooks();
		//then
		assertEquals(Collections.emptyList(), actual);
	}
	
	@Test
	void test_FindBooksById_ShouldReturnBook_WhenIdValid() {
		// given
		Books expected=book;
		when(repoMock.findBookById(1, "aniket")).thenReturn(expected);
		//when
		Books actual=bserv.findBookById(1, "aniket");
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	void test_FindBooksById_ShouldThrowError_WhenIdInValid() {
		// given
		when(repoMock.findBookById(-11, "aniket")).thenThrow(NotFoundException.class);
		//when
		//then
		assertThrows(NotFoundException.class, () -> bserv.findBookById(-11, "aniket"));
	}
	
	@Test
	void test_UpdateBookById_ShouldReturnBook_WhenBookValid() {
		// given
		Books expected=book;
		when(repoMock.updateBookById(expected,1)).thenReturn(expected);
		//when
		Books actual=bserv.updateBookById(expected, 1);
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	void test_UpdateBookById_ShouldThrowError_WhenBookInValid() {
		// given
		Books expected=book;
		when(repoMock.updateBookById(expected,-11)).thenThrow(ConstraintViolationException.class);
		//when
		//then
		assertThrows(ConstraintViolationException.class, () -> bserv.updateBookById(expected, -11));
	}
	
	@Test
	void test_BorrowBooks_ShouldReturnBook_WhenBookValid() {
		// given
		Books expected=book;
		when(repoMock.borrowBooks(1, expected)).thenReturn(expected);
		//when
		Books actual=bserv.borrowBooks(expected,1);
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	void test_BorrowBooks_ShouldThrowError_WhenBookInValid() {
		// given
		Books expected=book;
		when(repoMock.borrowBooks(1, expected)).thenThrow(ConstraintViolationException.class);
		//when
		//then
		assertThrows(ConstraintViolationException.class, () -> bserv.borrowBooks(expected,1));
	}
	
	@Test
	void test_DeleteBooks_ShouldReturnBook_WhenIdValid() {
		// given
		Books expected=book;
		when(repoMock.deleteById(1, "aniket")).thenReturn(expected);
		//when
		Books actual=bserv.deleteBookById(1, "aniket");
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	void test_DeleteBooks_ShouldThrowError_WhenIdNotFound() {
		// given
		when(repoMock.deleteById(21, "aniket")).thenThrow(NotFoundException.class);
		//when
		//then
		assertThrows(NotFoundException.class, () -> bserv.deleteBookById(21, "aniket"));
	}
	
	@Test
	void test_DeleteBooks_ShouldThrowError_WhenIdIValid() {
		// given
		when(repoMock.deleteById(-11, "aniket")).thenThrow(ConstraintViolationException.class);
		//when
		//then
		assertThrows(ConstraintViolationException.class, () -> bserv.deleteBookById(-11, "aniket"));
	}
	
}
