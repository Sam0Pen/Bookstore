package project.bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;
import project.bookstore.domain.Category;



@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;
	
	
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Lord of the rings");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Lord of the rings");
	}
	
	@Test
	public void createNewBookAndDelete() {
		Book book = new Book("Harry Potter", "Rowling", 1999, "8544373191725", 20, new Category("Teen"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
		repository.delete(book);
		assertThat(repository.count()).isEqualTo(2);
		
	}
	
	
}
