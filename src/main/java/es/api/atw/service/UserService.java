package es.api.atw.service;

import java.util.List;

import es.api.atw.model.User;
import javassist.NotFoundException;

public interface UserService {

	boolean createUser(User user);

	boolean editUser(User user);

	User getUserById(int id) throws NotFoundException;

	void deleteUserById(int id);

	List<User> getAllUsers();

}
