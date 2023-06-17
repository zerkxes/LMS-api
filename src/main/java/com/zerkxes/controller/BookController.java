package com.zerkxes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zerkxes.entity.Books;

@RequestMapping("/book")
public interface BookController {

	@GetMapping(value = "/list/")
	public List<Books> listAllBooks();

	@PostMapping(value = "/add/")
	public Books addBook(@RequestBody Books book);

	@PostMapping(value = "/borrow/{userId}")
	public Books borrowBook(@RequestBody Books book, @PathVariable int userId);

	@GetMapping(value = "/return/{userId}/{bookId}")
	public void returnBook(@PathVariable int userId, @PathVariable int bookId);

	@GetMapping(value = "/find/{owner}/{id}")
	public Books findBookById(@PathVariable String owner, @PathVariable int id);

	@PostMapping(value = "/update/{id}")
	public Books updateBook(@RequestBody Books book, @PathVariable int id);

	@DeleteMapping(value = "/delete/{owner}/{id}")
	public Books deleteBook(@PathVariable int id, @PathVariable String owner);
}
