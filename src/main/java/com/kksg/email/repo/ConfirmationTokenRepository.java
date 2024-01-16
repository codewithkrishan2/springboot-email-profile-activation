package com.kksg.email.repo;

import org.springframework.data.repository.CrudRepository;

import com.kksg.email.entity.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {
	
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
