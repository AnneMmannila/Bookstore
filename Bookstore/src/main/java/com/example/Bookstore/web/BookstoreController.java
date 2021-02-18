package com.example.Bookstore.web;

import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookstoreController {

	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private BookRepository repos;
	
	@Autowired
	private CategoryRepository crepos;
	
	@RequestMapping(value ={"/", "/bookstore"})
	public String listOfBooks(Model model) {
		
		model.addAttribute("books", repos.findAll());
		
		return "page";
	}
	
	// RESTful service to get all students
    @RequestMapping(value="/bookstore", method = RequestMethod.GET)
    public @ResponseBody List<Book> booksRest() {	
        return (List<Book>) repos.findAll();
    }    

	// RESTful service to get student by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findStudentRest(@PathVariable("id") Long bookId) {	
    	return repos.findById(bookId);
    }  
	
	
    @RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
	 repos.deleteById(id);
	 return "redirect:../bookstore";
	}
	
    @RequestMapping(value = "/add")
    public String addBook(Model model){
     model.addAttribute("book", new Book());
     model.addAttribute("categories", crepos.findAll());
     
     return "addBook";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
     repos.save(book);
     return "redirect:bookstore";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model){
    model.addAttribute("book", repos.findById(bookId));
    model.addAttribute("books", repos.findAll());
    model.addAttribute("categories", crepos.findAll());
    System.out.println(crepos.findAll());
    return "editBook";
    }
 
}