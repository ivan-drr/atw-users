package es.api.atw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.api.atw.model.User;
import es.api.atw.repository.UserRepository;
import es.api.atw.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean createUser(User user) {
		return this.userRepository.createUser(user);
	}

	@Override
	public boolean editUser(User user) {
		return this.userRepository.editUser(user);
	}

	@Override
	public User getUserById(int id) {
		return this.userRepository.getUserById(id);
	}

	@Override
	public boolean deleteUserById(int id) {
		return this.userRepository.deleteUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.getAllUsers();
	}

}
