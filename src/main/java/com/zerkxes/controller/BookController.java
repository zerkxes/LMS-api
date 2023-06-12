package com.zerkxes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerkxes.entity.Books;
import com.zerkxes.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bserv;

	@GetMapping(value = "/list/")
	public List<Books> listAllBooks() {
		return bserv.listAllBooks();
	}

	@PostMapping(value = "/add/")
	public Books addBook(@RequestBody Books book) {
		return bserv.createBook(book);
	}
	
	@PostMapping(value="/borrow/{userId}")
	public Books borrowBook(@RequestBody Books book, @PathVariable int userId) {
		return bserv.borrowBooks(book, userId);
	}

	@GetMapping(value = "/find/{owner}/{id}")
	public Books findBookById(@PathVariable String owner, @PathVariable int id) {
		return bserv.findBookById(id, owner);
	}

	@PostMapping(value = "/update/{id}")
	public Books updateBook(@RequestBody Books book, @PathVariable int id) {
		return bserv.updateBookById(book, id);
	}

	@DeleteMapping(value = "/delete/{owner}/{id}")
	public Books deleteBook(@PathVariable int id, @PathVariable String owner) {
		return bserv.deleteBookById(id, owner);
	}

}
