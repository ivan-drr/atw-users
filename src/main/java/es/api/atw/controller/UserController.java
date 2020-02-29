package es.api.atw.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.api.atw.exceptions.ResourceNotFoundException;
import es.api.atw.model.UserEntity;
import es.api.atw.service.UserService;

@RestController
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("")
	public List<UserEntity> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("id") int id) throws ResourceNotFoundException {
		return this.userService.getUserById(id);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/nick/{nickname}")
	public ResponseEntity<UserEntity> getUserByNickname(@PathVariable("nickname") String nickname)
			throws ResourceNotFoundException {
		return this.userService.getUserByNickname(nickname);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	public UserEntity getUserById(@RequestBody UserEntity user) {
		return this.userService.createUser(user);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/update")
	public ResponseEntity<UserEntity> updateUserById(@RequestBody UserEntity user) throws ResourceNotFoundException {
		return this.userService.editUser(user);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteUserById(@PathVariable("id") int id) throws ResourceNotFoundException {
		return this.userService.deleteUserById(id);
	}

}
