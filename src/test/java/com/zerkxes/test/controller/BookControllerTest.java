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

import com.zerkxes.controller.BookControllerImpl;
import com.zerkxes.entity.Books;
import com.zerkxes.exception.NotFoundException;
import com.zerkxes.service.BookService;

import jakarta.validation.ConstraintViolationException;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

	@Mock
	private BookService bservMock;
	@InjectMocks
	private BookControllerImpl bcontroller;
	private Books book;

	@BeforeEach
	void setup() {
		book = new Books(1, "LOTR", null, "aniket", null, null);
	}

	@Test
	void test_ListAllBooks_ShouldReturnList_WhenBooksExist() {
		// given
		List<Books> expected=new ArrayList<>(List.of(book));
		when(bservMock.listAllBooks()).thenReturn(expected);
		//when
		ResponseEntity<List<Books>> actual=bcontroller.listAllBooks();
		//then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual);
	}
	
	@Test
	void test_ListAllBooks_ShouldReturnEmptyArray_WhenEmpty() {
		// given
		//List<Books> expected=new ArrayList<>(List.of(book));
		when(bservMock.listAllBooks()).thenReturn(Collections.emptyList());
		//when
		ResponseEntity<List<Books>> actual=bcontroller.listAllBooks();
		//then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(Collections.emptyList(), actual);
	}
	
	@Test
	void test_FindBooksById_ShouldReturnBook_WhenIdValid() {
		// given
		Books expected=book;
		when(bservMock.findBookById(1, "aniket")).thenReturn(expected);
		//when
		ResponseEntity<Books> actual=bcontroller.findBookById("aniket", 1);
		//then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual);
	}
	
	@Test
	void test_FindBooksById_ShouldThrowError_WhenIdInValid() {
		// given
		when(bservMock.findBookById(-11, "aniket")).thenThrow(NotFoundException.class);
		//when
		//then
		assertThrows(NotFoundException.class, () -> bcontroller.findBookById("aniket", -11));
	}
	
	@Test
	void test_UpdateBookById_ShouldReturnBook_WhenBookValid() {
		// given
		Books expected=book;
		when(bservMock.updateBookById(expected,1)).thenReturn(expected);
		//when
		ResponseEntity<Books> actual=bcontroller.updateBook(expected, 1);
		//then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual);
	}
	
	@Test
	void test_UpdateBookById_ShouldThrowError_WhenBookInValid() {
		// given
		Books expected=book;
		when(bservMock.updateBookById(expected,-11)).thenThrow(ConstraintViolationException.class);
		//when
		//then
		assertThrows(ConstraintViolationException.class, () -> bcontroller.updateBook(expected, -11));
	}
	
	@Test
	void test_BorrowBooks_ShouldReturnBook_WhenBookValid() {
		// given
		Books expected=book;
		when(bservMock.borrowBooks(expected, 1)).thenReturn(expected);
		//when
		ResponseEntity<Books> actual=bcontroller.borrowBook(expected,1);
		//then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual);
	}
	
	@Test
	void test_BorrowBooks_ShouldThrowError_WhenBookInValid() {
		// given
		Books expected=book;
		when(bservMock.borrowBooks(expected, 1)).thenThrow(ConstraintViolationException.class);
		//when
		//then
		assertThrows(ConstraintViolationException.class, () -> bcontroller.borrowBook(expected,1));
	}
	
	@Test
	void test_DeleteBooks_ShouldReturnBook_WhenIdValid() {
		// given
		Books expected=book;
		when(bservMock.deleteBookById(1, "aniket")).thenReturn(expected);
		//when
		ResponseEntity<Books> actual=bcontroller.deleteBook(1, "aniket");
		//then
		assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(actual.hasBody());
		assertEquals(expected, actual);
	}
	
	@Test
	void test_DeleteBooks_ShouldThrowError_WhenIdNotFound() {
		// given
		when(bservMock.deleteBookById(21, "aniket")).thenThrow(NotFoundException.class);
		//when
		//then
		assertThrows(NotFoundException.class, () -> bcontroller.deleteBook(21, "aniket"));
	}
	
	@Test
	void test_DeleteBooks_ShouldThrowError_WhenIdIValid() {
		// given
		when(bservMock.deleteBookById(-11, "aniket")).thenThrow(ConstraintViolationException.class);
		//when
		//then
		assertThrows(ConstraintViolationException.class, () -> bcontroller.deleteBook(-11, "aniket"));
	}

}
