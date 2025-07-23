package com.example.unitTest;

import com.example.unitTest.model.User;
import com.example.unitTest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UnitTestApplicationTests {



		@Autowired
		private UserService userService;

		@Test
		void testCrudOperations() {
			// Create
			User user = new User("John Doe", "john@example.com");
			User savedUser = userService.createUser(user);
			assertNotNull(savedUser.getId());
			assertEquals("John Doe", savedUser.getName());
			assertEquals("john@example.com", savedUser.getEmail());

			// Read (By ID)
			Optional<User> foundUser = userService.getUserById(savedUser.getId());
			assertTrue(foundUser.isPresent());
			assertEquals("John Doe", foundUser.get().getName());

			// Read (All)
			List<User> users = userService.getAllUsers();
			assertFalse(users.isEmpty());
			assertEquals(1, users.size());

			// Update
			User updatedDetails = new User("Jane Doe", "jane@example.com");
			User updatedUser = userService.updateUser(savedUser.getId(), updatedDetails);
			assertEquals("Jane Doe", updatedUser.getName());
			assertEquals("jane@example.com", updatedUser.getEmail());

			// Delete
			userService.deleteUser(savedUser.getId());
			Optional<User> deletedUser = userService.getUserById(savedUser.getId());
			assertFalse(deletedUser.isPresent());
		}
	}

