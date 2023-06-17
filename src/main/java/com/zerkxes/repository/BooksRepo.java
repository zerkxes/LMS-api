package com.zerkxes.repository;

import java.util.List;

import com.zerkxes.entity.Books;

public interface BooksRepo {
	public Books createBook(Books book);

	public List<Books> listAllBooks();

	public Books findBookById(int id, String owner);

	public Books updateBookById(Books book, int id);

	public Books borrowBooks(int userId, Books book);

	public void returnBooks(int userId, int bookId);

	public Books deleteById(int id, String owner);
}
