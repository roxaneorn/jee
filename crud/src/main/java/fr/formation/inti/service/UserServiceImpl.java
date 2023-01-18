package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.dao.UserDaoImpl;
import fr.formation.inti.entity.User;

public class UserServiceImpl implements UserService{

	UserDaoImpl dao;
	
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

	@Override
	public User findById(Integer id) {
		dao.beginTransaction();
		User u = dao.findById(id);
		dao.commit(true);
		return u;
	}

	@Override
	public List<User> findAll() {
		dao.beginTransaction();
		List<User> list = dao.findAll();
		dao.commit(true);
		return list;
	}

	@Override
	public Integer save(User u) {
		dao.beginTransaction();
		User user = dao.save(u);
		dao.commit(true);
		return user.getIdUser();
	}

	@Override
	public void delete(User u) {
		dao.beginTransaction();
		dao.delete(u);
		dao.commit(true);
		
	}
	


	@Override
	public void deleteById(Integer id) {
		dao.beginTransaction();
		dao.deleteById(id);
		dao.commit(true);
		
	}

	@Override
	public User findByEmail(String email) {
		dao.beginTransaction();
		User u = dao.findByEmail(email);
		dao.commit(true);
		return u;
	}

}
