package com.zerkxes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerkxes.entity.Books;
import com.zerkxes.repository.BooksRepoImpl;

@Service
public class BookServiceImpl {
	
	@Autowired
	private BooksRepoImpl repo;
	
	public Books createBook(Books Book) {
		return repo.createBook(Book);
	}
	
	public List<Books> listAllBooks() {
		return repo.listAllBooks();
	}
	
	public Books findBookById(int id, String owner) {
		return repo.findBookById(id, owner);
	}
	
	public Books updateBookById(Books book, int id) {
		return repo.updateBookById(book, id);
	}
	
	public Books borrowBooks(Books book, int id) {
		return repo.borrowBooks(id, book);
	}
	
	public void returnBooks(int userId, int bookId) {
		repo.returnBooks(userId, bookId);
	}
	
	public Books deleteBookById(int id, String owner) {
		return repo.deleteById(id, owner);
	}
}
