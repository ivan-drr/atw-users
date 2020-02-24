package es.api.atw.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.api.atw.model.User;
import es.api.atw.repository.UserRepository;
import es.api.atw.service.UserService;
import javassist.NotFoundException;

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
	public boolean createUser(User user) {
		return this.userRepository.save(user) != null;
	}

	@Override
	public boolean editUser(User user) {
		if (this.userRepository.findById(user.getId()) == null) {
			return false;
		}
		return this.userRepository.save(user) != null;
	}

	@Override
	public User getUserById(int id) throws NotFoundException {
		return this.userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("No se pudo encontrar el usuario con id: " + id));
	}

	@Override
	public void deleteUserById(int id) {
		this.userRepository.deleteById(id);;
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) this.userRepository.findAll();
	}

}
