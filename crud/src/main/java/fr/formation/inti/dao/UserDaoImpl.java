package fr.formation.inti.dao;



import org.hibernate.query.Query;

import fr.formation.inti.entity.User;

public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao{
	
	@Override
	public User findByEmail(String email) {
		String hql ="from User where email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		User user = (User) query.uniqueResult();
		return user;
	}
	

}
