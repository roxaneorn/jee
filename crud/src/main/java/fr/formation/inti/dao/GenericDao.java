package fr.formation.inti.dao;

import java.util.List;

public interface GenericDao<T, ID> {
	
	 T findById(ID id);
	 List<T> findAll();
	 T save(T entiy);
	 void delete(T entiy);
	 void deleteById(ID id);
}
