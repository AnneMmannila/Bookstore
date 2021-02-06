package com.example.Bookstore.web;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookstoreController {

	@Autowired
	private BookRepository repos;
	
	@RequestMapping(value ={"/", "/bookstore"})
	public String listOfBooks(Model model) {
		
		model.addAttribute("books", repos.findAll());
		
		return "page";
	}
	
    @RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
	 repos.deleteById(id);
	 return "redirect:../bookstore";
	}
	
    @RequestMapping(value = "/add")
    public String addBook(Model model){
     model.addAttribute("book", new Book());
     
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
    return "editBook";
    }

}