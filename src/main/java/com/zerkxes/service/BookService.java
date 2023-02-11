package com.zerkxes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerkxes.entity.Books;
import com.zerkxes.repository.BooksRepo;

@Service
public class BookService {
	
	@Autowired
	private BooksRepo repo;
	
	public Books createBook(Books Book) {
		return repo.createBook(Book);
	}
	
	public List<Books> listAllBooks(String owner) {
		return repo.listAllBooks(owner);
	}
	
	public Books findBookById(int id, String owner) {
		return repo.findBookById(id, owner);
	}
	
	public Books updateBookById(Books book, int id) {
		return repo.updateBookById(book, id);
	}
	
	public Books deleteBookById(int id, String owner) {
		return repo.deleteById(id, owner);
	}
}
