package es.api.atw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.api.atw.model.User;
import es.api.atw.service.UserService;

@RestController()
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return this.userService.getUserById(id);
	}

	@PostMapping("/create")
	public boolean getUserById(@RequestBody User user) {
		return this.userService.createUser(user);
	}

	@PutMapping("/update")
	public boolean updateUserById(@RequestBody User user) {
		return this.userService.editUser(user);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteUserById(@PathVariable("id") int id) {
		return this.userService.deleteUserById(id);
	}

}
