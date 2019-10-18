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
import project.bookstore.domain.CategoryRepository;
import project.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {
	@Autowired
	private BookRepository repository1;
	private CategoryRepository repository2;
	private UserRepository repository3;
	
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository1.findByTitle("Lord of the rings");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Lord of the rings");
	}
	
	@Test
	public void createNewBookAndDelete() {
		Book book = new Book("Harry Potter", "Rowling", 1999, "8544373191725", 20, new Category("Teen"));
		repository1.save(book);
		assertThat(book.getId()).isNotNull();
		repository1.delete(book);
		
	}
	
	@Test
	public void findByNamehouldReturnCategory() {
		List<Category> cats = repository2.findByName("Fantasy");
		assertThat(cats).hasSize(2);
		assertThat(cats.get(0).getName()).isEqualTo("Fantasy");
	}
	
	@Test
	public void createNewCategoryAndDelete() {
		Category category = new Category("Manga");
		repository2.save(category);
		assertThat(category.getCategoryid()).isNotNull();
		repository2.delete(category);
		
		
	}
	
	
}
