package com.zerkxes.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zerkxes.entity.Books;

@Repository
public class BooksRepo {

	@Autowired
	private JdbcTemplate repo;

	private String insertBook = "insert into BOOKS values(?,?,?,?,?,?)";
	private String listAllBooks = "select * from BOOKS where owner=?";
	private String findBookById = "select * from BOOKS where id=? and owner=?";
	private String updateBookById = "update BOOKS set b_date=?, name=?, owner=?, r_date=?, u_name=? where id=?";
	private String deleteBookById = "delete from BOOKS where id=?";

	public Books createBook(Books book) {
		repo.update(insertBook, book.getId(),book.getB_date(), book.getName(),  book.getOwner(),book.getR_date(),
				book.getU_name());
		return book;
	}

	public List<Books> listAllBooks(String owner) {
		return repo.query(listAllBooks, new BeanPropertyRowMapper<>(Books.class), owner);
	}

	public Books findBookById(int id, String owner) {
		return repo.queryForObject(findBookById, new BeanPropertyRowMapper<>(Books.class), id, owner);
	}

	public Books updateBookById(Books book, int id) {
		repo.update(updateBookById, book.getB_date(), book.getName(),  book.getOwner(),book.getR_date(),
				book.getU_name(), id);
		return book;
	}

	public Books deleteById(int id, String owner) {
		Books x = findBookById(id, owner);
		repo.update(deleteBookById, id);
		return x;
	}
}
