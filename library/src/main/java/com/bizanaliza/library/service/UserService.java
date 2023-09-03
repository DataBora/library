package com.bizanaliza.library.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bizanaliza.library.domain.User;
import com.bizanaliza.library.domain.UserQueries;
import com.bizanaliza.library.rest.ErrorMessages;
import com.bizanaliza.library.utils.AttributeLengthValidation;
import com.bizanaliza.library.utils.EmailValidation;

@Stateless
public class UserService {

	@PersistenceContext
	private EntityManager em;
	
	public User createUser(User user) {
		
		//proveravamo uslove kad nam sa neta stigne zahtev
		AttributeLengthValidation.checkLenght(user.getName(), 30);
		AttributeLengthValidation.checkLenght(user.getSurname(), 30);
//		checkLenght(user.getName(), 30);
//		checkLenght(user.getSurname(), 30);
		
		if(!EmailValidation.validate(user.getEmail())) {
			throw new AppException(ErrorMessages.invalid_email_format);
		}
		
		//proveravamo bazu da li postoji email ili user
		if(UserQueries.emailExists(em, user.getEmail())) {
			throw new AppException(ErrorMessages.user_email_exists);
		}
		
		if(UserQueries.usernameExists(em, user.getUsername())) {
			throw new AppException(ErrorMessages.user_username_exists);
		}
		
		em.persist(user);
		return user; 
	}
	
	
	
}
