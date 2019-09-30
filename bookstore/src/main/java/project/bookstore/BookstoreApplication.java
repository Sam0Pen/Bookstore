package project.bookstore;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;
import project.bookstore.domain.Category;
import project.bookstore.domain.CategoryRepository;
import project.bookstore.domain.User;
import project.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository catrepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			catrepository.save(new Category("Fantasy"));
			catrepository.save(new Category("Thriller"));
			catrepository.save(new Category("Sci-Fi"));
			
			bookRepository.save(new Book("Lord of the rings", "J.R.R Tolkien", 1954, "9788373191723", 24, catrepository.findByName("Fantasy").get(0)));
			bookRepository.save(new Book("Hobit: there and back again", "J.R.R Tolkien", 1975, "8544373191725", 20, catrepository.findByName("Fantasy").get(0)));
			
			User user1 = new User("user", "$2a$10$rFq5BtUSPzMRQw7fAcWGPuIfUAAg6W3Y5XnnH7s9vk6DtF10xdiOO", "USER");
			User user2 = new User("admin", "$2a$10$t2fx7FhEQhq371z2Pmp81Ojqat30BvVnq7thZc0mTXOh5Ngj3uhSe", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
