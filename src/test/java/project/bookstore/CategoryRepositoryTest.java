package project.bookstore;


import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;



import project.bookstore.domain.Category;
import project.bookstore.domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository repository;
	
	
	@Test
	public void findByNamehouldReturnCategory() {
		List<Category> cats = repository.findByName("Fantasy");
		assertThat(cats).hasSize(1);
		assertThat(cats.get(0).getName()).isEqualTo("Fantasy");
	}
	
	@Test
	public void createNewCategoryAndDelete() {
		Category category = new Category("Manga");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
		assertThat(repository.count()).isEqualTo(4);
		repository.delete(category);
		assertThat(repository.count()).isEqualTo(3);
		
		
	}

}
