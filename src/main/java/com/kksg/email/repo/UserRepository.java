package com.kksg.email.repo;

import org.springframework.data.repository.CrudRepository;

import com.kksg.email.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmailIgnoreCase(String email);
}
