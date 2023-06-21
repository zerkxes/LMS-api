package com.zerkxes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zerkxes.entity.Books;
import com.zerkxes.service.BookService;

@RestController
public class BookControllerImpl implements BookController {

	@Autowired
	private BookService bserv;

	@Override
	public ResponseEntity<List<Books>> listAllBooks() {
		return new ResponseEntity<>(bserv.listAllBooks(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Books> addBook(@RequestBody Books book) {
		return new ResponseEntity<>(bserv.createBook(book), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Books> borrowBook(@RequestBody Books book, @PathVariable int userId) {
		return new ResponseEntity<>(bserv.borrowBooks(book, userId), HttpStatus.OK);
	}

	@Override
	public void returnBook(@PathVariable int userId, @PathVariable int bookId) {
		bserv.returnBooks(userId, bookId);
	}

	@Override
	public ResponseEntity<Books> findBookById(@PathVariable String owner, @PathVariable int id) {
		return new ResponseEntity<>(bserv.findBookById(id, owner), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Books> updateBook(@RequestBody Books book, @PathVariable int id) {
		return new ResponseEntity<>(bserv.updateBookById(book, id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Books> deleteBook(@PathVariable int id, @PathVariable String owner) {
		return new ResponseEntity<>(bserv.deleteBookById(id, owner), HttpStatus.OK);
	}

}
