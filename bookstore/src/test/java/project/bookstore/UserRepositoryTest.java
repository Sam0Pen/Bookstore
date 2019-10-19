package project.bookstore;


import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import project.bookstore.domain.User;
import project.bookstore.domain.UserRepository;






@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;
	
	
	@Test
	public void findByUsernamehouldReturnUser() {
		List<User> users = repository.findByUsernames("admin");
		assertThat(users).hasSize(1);
		assertThat(users.get(0).getUsername()).isEqualTo("admin");
	}
	
	@Test
	public void createNewCategoryAndDelete() {
		User user = new User("Vieras", "$2a$10$t2fx7FhEQhq371z2Pmp81Ojqat30BvVnq7thZc0mTXOh5Ngj3uhSe", "ADMIN");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
		assertThat(repository.count()).isEqualTo(3);
		repository.delete(user);
		assertThat(repository.count()).isEqualTo(2);
		
		
	}

}
