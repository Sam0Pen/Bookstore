package project.bookstore.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String newBook(Model model){
		model.addAttribute("book", new Book());
		return "index";
		
	}

}
