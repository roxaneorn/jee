package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entity.User;

public interface UserService {
	User findById(Integer id);

	List<User> findAll();

	Integer save(User entiy);

	void delete(User entiy);

	void deleteById(Integer id);

	User findByEmail(String email);
	
	

}
