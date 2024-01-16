package com.kksg.email.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

	/*
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/confirm").permitAll();
        }
      */ 
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        	http	
            		.authorizeHttpRequests(auth -> auth
	                    .requestMatchers("/register").permitAll()
	                    .requestMatchers("/confirm").permitAll()
	                    .anyRequest()
	                    .authenticated()
	                 );

    		//DefaultSecurityFilterChain build = http.build();
    	    		
    		return http.build();
    		
    	}
}