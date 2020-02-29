package es.api.atw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import es.api.atw.exceptions.ResourceNotFoundException;
import es.api.atw.model.UserEntity;
import es.api.atw.repository.UserRepository;
import es.api.atw.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return (List<UserEntity>) this.userRepository.findAll();
	}

	@Override
	public ResponseEntity<UserEntity> getUserById(@PathVariable(value = "id") int userId)
			throws ResourceNotFoundException {
		final UserEntity user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	@Override
	public UserEntity createUser(@Valid @RequestBody UserEntity user) {
		return this.userRepository.save(user);
	}

	@Override
	public ResponseEntity<UserEntity> editUser(@Valid @RequestBody UserEntity user) throws ResourceNotFoundException {
		final UserEntity userToUpdate = this.userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + user.getId()));

		userToUpdate.setNickname(user.getNickname());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setName(user.getName());
		userToUpdate.setBirthYear(user.getBirthYear());

		final UserEntity updatedUser = this.userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	@Override
	public Map<String, Boolean> deleteUserById(@PathVariable(value = "id") int userId)
			throws ResourceNotFoundException {
		final UserEntity user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		this.userRepository.delete(user);
		final Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@Override
	public ResponseEntity<UserEntity> getUserByNickname(String nickname) throws ResourceNotFoundException {
		final UserEntity user = this.userRepository.findByNickname(nickname)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this nickname :: " + nickname));
		return ResponseEntity.ok().body(user);
	}

}
