package com.api.user.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.user.Entity.User;
import com.api.user.dao.userRepository;

@Component
public class UserService {
	@Autowired
	private userRepository userRep;
	
	public List<User> getAllUsers(){
		List<User> list =(List<User>) userRep.findAll();
		return list;
	}
	
	public User getUserById(int id) {
		User user=null;
		try {
			user = userRep.findById(id);}
			catch(Exception e) {
			e.printStackTrace();
		}
		
	 return user;
	}
	
	public void addBook(User u) {
		userRep.save(u);
	}
	
	public void deleteUserById(int id) {
		userRep.deleteById(id); 
	}
	
	public void deleteAllUser(){
		userRep.deleteAll();
	}

	public void updateUserById(User user,int id) {
		 user.setId(id);
		 userRep.save(user);
	}
	
	
}
