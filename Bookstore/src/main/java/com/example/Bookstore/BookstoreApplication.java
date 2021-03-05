package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;



@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepos, UserRepository urepository) {
	return (args) -> {
	 
		//String title, String author, long year, long price
		Book b = new Book("Liisa ihmemaassa", "J.R Lewis", 1970, 60);
		Book c = new Book("Ascent of money", "Nial Ferguson", 2007, 44);
		Book d = new Book("Pahan varjo", "	John Grisham", 2020, 20);
		repository.save(b);
		repository.save(c);
		repository.save(d);
		
		Category ab = new Category("Fiction");
		Category ac = new Category("Science");
		Category ad = new Category("Horror");
		crepos.save(ab);
		crepos.save(ac);
		crepos.save(ad);
		
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","user@gmail.com", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","admin@gmail.com", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		
	};
	}
	
}
