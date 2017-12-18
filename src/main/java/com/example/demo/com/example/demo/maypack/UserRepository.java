package com.example.demo.com.example.demo.maypack;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
 public User findById(int id);
}
