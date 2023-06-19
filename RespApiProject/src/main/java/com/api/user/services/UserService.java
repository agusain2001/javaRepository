package com.api.user.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.user.Entity.User;

@Component
public class UserService {
	private static List<User> list = new ArrayList<>();
	static {
		list.add(new User(1,"Ashish","ktd"));
		list.add(new User(2,"AshishG","dun"));
	}
	
	public List<User> getAllUsers(){
		return list;
	}
	
	public User getUserById(int id) {
		User user=null;
		try {
	 user=list.stream().filter(e->e.getId()==id).findFirst().get();}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	 return user;
	}
	
	public User addBook(User u) {
		list.add(u);
		return u;
	}
	
	public User deleteUserById(int id) {
		User user=null;
		 user=list.stream().filter(e->e.getId()==id).findFirst().get();
		list.remove(user);
		 return user;
	}
	
	public void deleteAllUser(){
		list=null;
	}

	public void updateUserById(User user,int id) {
		 list=list.stream().map(b->{
			 if(b.getId()==id) {
				 b.setName(user.getName());
				 b.setCity(user.getCity());
			 }
			 return b;
		 }).collect(Collectors.toList());
	}
	
	
}
