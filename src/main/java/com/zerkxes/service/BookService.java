package com.zerkxes.service;

import java.util.List;

import com.zerkxes.entity.Books;

public interface BookService {

	public Books createBook(Books Book);

	public List<Books> listAllBooks();

	public Books findBookById(int id, String owner);

	public Books updateBookById(Books book, int id);

	public Books borrowBooks(Books book, int id);

	public void returnBooks(int userId, int bookId);

	public Books deleteBookById(int id, String owner);

}
