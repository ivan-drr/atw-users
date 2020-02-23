package es.api.atw.repository;

import java.util.List;

import es.api.atw.model.User;

public interface UserRepository {

	boolean createUser(User user);

	boolean editUser(User user);

	User getUserById(int id);

	boolean deleteUserById(int id);

	List<User> getAllUsers();

}
