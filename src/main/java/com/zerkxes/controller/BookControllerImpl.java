package com.zerkxes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zerkxes.entity.Books;
import com.zerkxes.service.BookServiceImpl;

@RestController
public class BookControllerImpl implements BookController {

	@Autowired
	private BookServiceImpl bserv;

	@Override
	public List<Books> listAllBooks() {
		return bserv.listAllBooks();
	}

	@Override
	public Books addBook(@RequestBody Books book) {
		return bserv.createBook(book);
	}

	@Override
	public Books borrowBook(@RequestBody Books book, @PathVariable int userId) {
		return bserv.borrowBooks(book, userId);
	}

	@Override
	public void returnBook(@PathVariable int userId, @PathVariable int bookId) {
		bserv.returnBooks(userId, bookId);
	}

	@Override
	public Books findBookById(@PathVariable String owner, @PathVariable int id) {
		return bserv.findBookById(id, owner);
	}

	@Override
	public Books updateBook(@RequestBody Books book, @PathVariable int id) {
		return bserv.updateBookById(book, id);
	}

	@Override
	public Books deleteBook(@PathVariable int id, @PathVariable String owner) {
		return bserv.deleteBookById(id, owner);
	}

}
