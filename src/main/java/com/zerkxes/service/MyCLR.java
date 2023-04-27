package com.zerkxes.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zerkxes.entity.Books;
import com.zerkxes.entity.Users;
import com.zerkxes.entity.Users.role;

@Component
public class MyCLR implements CommandLineRunner {
	
	@Autowired
	private UserService userv;
	
	@Autowired
	private BookService bserv;

	@Override
	public void run(String... args) throws Exception {
		//userv.createUser(new Users(1, "aniket", "zerkxes", "$$lau", role.Librarian, "aniket"));
		//userv.updateUser(new Users(1, "bose", "zawdwds", "$$lau", role.Librarian, "aniket"));
		//userv.createUser(new Users(2, "aniket", "asdaw", "$$lau", role.Librarian, "aniket"));
		//System.out.println(userv.findById(1));
		//System.out.println(userv.findByUserName("asdaw"));
		//System.out.println(userv.listAllUsers("aniket"));
		//userv.deleteUser(1);
		//bserv.createBook(new Books(1, "LOTR", "zerkxes", "aniket", LocalDate.of(2000, 12, 13), LocalDate.of(2000,12,14)));
		//bserv.createBook(new Books(3, "LOTR", "zerkxes", "aniket", LocalDate.of(2000,12,13),  LocalDate.of(2000,12,14)));
		//System.out.println(bserv.listAllBooks("aniket"));
		//System.out.println(bserv.findBookById(3, "aniket"));
		//bserv.updateBookById(new Books(3, "Space time", "atuny0", "aniket", LocalDate.of(2000, 12, 13), LocalDate.of(2000,12,14)), 3);
		//bserv.deleteBookById(1, "aniket");
	}

}
