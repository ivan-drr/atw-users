package es.api.atw.service;

import java.util.List;

import es.api.atw.model.User;

public interface UserService {

	boolean createUser(User user);

	boolean editUser(User user);

	User getUserById(int id);

	boolean deleteUserById(int id);

	List<User> getAllUsers();

}
