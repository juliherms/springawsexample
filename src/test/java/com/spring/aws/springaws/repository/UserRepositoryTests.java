package com.spring.aws.springaws.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.aws.springaws.domain.User;
import com.spring.aws.springaws.domain.enums.Role;


/**
 * Class responsible to test UserRepository
 * 
 * @author j.a.vasconcelos
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;

	@Test
	public void aSaveTest() {

		User user = new User();
		user.setName("Juliherms");
		user.setEmail("j.a.vasconcelos321@gmail.com");
		user.setPassword("12345");
		user.setRole(Role.ADMINISTRATOR);
		user.setRequests(null);

		User createdUser = repo.save(user);

		assertThat(createdUser.getId()).isEqualTo(1L);
	}

	@Test
	public void updateTest() {

		User user = new User();
		user.setId(1L);
		user.setName("Juliherms Vasconcelos");
		user.setEmail("j.a.vasconcelos321@gmail.com");
		user.setPassword("12345");
		user.setRole(Role.ADMINISTRATOR);
		user.setRequests(null);

		User updatedUser = repo.save(user);

		assertThat(updatedUser.getName()).isEqualTo("Juliherms Vasconcelos");
	}

	@Test
	public void getByIdTest() {

		Optional<User> result = repo.findById(1L);
		User user = result.get();
		assertThat(user.getPassword()).isEqualTo("12345");
	}

	@Test
	public void listTest() {

		List<User> users = repo.findAll();

		assertThat(users.size()).isEqualTo(1);
	}

	@Test
	public void zloginTest() {

		Optional<User> result = repo.login("j.a.vasconcelos321@gmail.com", "12345");
		User loggedUser = result.get();

		assertThat(loggedUser.getId()).isEqualTo(1L);
	}
}
