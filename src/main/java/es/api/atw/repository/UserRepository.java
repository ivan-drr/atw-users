package es.api.atw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.api.atw.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {}
