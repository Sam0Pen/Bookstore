package project.bookstore.controller;



import java.util.List;

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
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "index";
		
	}

}
