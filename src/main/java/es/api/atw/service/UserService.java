package es.api.atw.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import es.api.atw.exceptions.ResourceNotFoundException;
import es.api.atw.model.UserEntity;

public interface UserService {

	UserEntity createUser(UserEntity user);

	ResponseEntity<UserEntity> editUser(UserEntity user) throws ResourceNotFoundException;

	ResponseEntity<UserEntity> getUserById(int id) throws ResourceNotFoundException;

	Map<String, Boolean> deleteUserById(int id) throws ResourceNotFoundException;

	List<UserEntity> getAllUsers();

	ResponseEntity<UserEntity> getUserByNickname(String nickname) throws ResourceNotFoundException;

}
