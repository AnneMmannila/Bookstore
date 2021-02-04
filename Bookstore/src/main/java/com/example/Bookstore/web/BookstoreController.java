package com.example.Bookstore.web;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.domain.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookstoreController {

	@RequestMapping(value ="/bookstore", method = RequestMethod.GET)
	public String hello(Model model) {
		Book iambook = new Book ("I am book", "Barak Obama", 2020, "123-ok222", 55);
		model.addAttribute("newbook", iambook);
		System.out.println("Hello GitHub!");
		return "page";
	}

}