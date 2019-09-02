package project.bookstore.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.bookstore.domain.Book;

@Controller
public class BookController {
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String newBook(Model model){
		model.addAttribute("book", new Book());
		return "index";
		
	}

}
