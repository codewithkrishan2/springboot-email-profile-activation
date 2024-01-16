package com.kksg.email.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long userid;

    private String email;

    private String password;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
	private String lastName;
    
    private boolean isEnabled;
}
