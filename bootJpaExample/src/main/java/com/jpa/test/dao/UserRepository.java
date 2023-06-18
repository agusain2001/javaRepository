package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name,String city);
	public List<User> findByNameEndingWith(String pattern);
	
	
	@Query("select u from User u where u.name =:n")
	public List<User> getAllUser(@Param("n")  String name);
	
}
