package com.api.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.user.Entity.User;

public interface userRepository extends CrudRepository<User, Integer> {
 public User findById(int id);
}
