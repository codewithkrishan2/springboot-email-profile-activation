package com.kksg.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kksg.email.entity.ConfirmationToken;
import com.kksg.email.entity.User;
import com.kksg.email.repo.ConfirmationTokenRepository;
import com.kksg.email.repo.UserRepository;
import com.kksg.email.service.EmailService;

@Controller
public class UserAccountController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ConfirmationTokenRepository tokenRepo;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/register")
    public ModelAndView displayRegistration
    				(ModelAndView modelAndView, User userEntity) {
		modelAndView.addObject("userEntity", userEntity);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	
	@PostMapping("/register")
	public ModelAndView registerUser(ModelAndView modelAndView, User userEntity) {
		
		User existingUser = userRepo.findByEmailIgnoreCase(userEntity.getEmail());
		//Check if email already exists
		if(existingUser != null) {
			modelAndView.addObject("message", "This email already exists!");
            modelAndView.setViewName("error");
		}
		else {
			userRepo.save(userEntity);
			ConfirmationToken token = new ConfirmationToken(userEntity);
			tokenRepo.save(token);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(userEntity.getEmail());
			mailMessage.setSubject("Complete Registration!");
			mailMessage.setFrom("krishankantsinghtesting@gmail.com");
			mailMessage.setText("To confirm your account, please click here : "
					+ "http://localhost:8080/confirm-account?token="
					+token.getConfirmationToken());
			emailService.sendEmail(mailMessage);
			modelAndView.addObject("email", userEntity.getEmail());
			modelAndView.setViewName("successfulRegisteration");
		}
		return modelAndView;
	}
	 	@RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
	    public ModelAndView confirmUserAccount(
	    		ModelAndView modelAndView, 
	    		@RequestParam("token") String confirmationToken){
	 		ConfirmationToken token = tokenRepo.findByConfirmationToken(confirmationToken);
	 		if (token!=null) {
				User user = userRepo.findByEmailIgnoreCase(token.getUserEntity().getEmail());
				user.setEnabled(true);
				userRepo.save(user);
				//tokenRepo.delete(token);
				modelAndView.setViewName("accountVerified");
			}
	 		else {
				modelAndView.addObject("message","The link is invalid or broken!");
				modelAndView.setViewName("error");
			}
		    return modelAndView;
	    }
	
}
