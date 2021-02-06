package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
	 
		//String title, String author, long year, long price
		Book b = new Book("Liisa ihmemaassa", "J.R Lewis", 1970, 60);
		Book c = new Book("Ascent of money", "Nial Ferguson", 2007, 44);
		Book d = new Book("Pahan varjo", "	John Grisham", 2020, 20);
		repository.save(b);
		repository.save(c);
		repository.save(d);
	};
	}
	
}
