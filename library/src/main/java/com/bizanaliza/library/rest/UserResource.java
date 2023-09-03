package com.bizanaliza.library.rest;

import javax.ejb.EJB;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bizanaliza.library.domain.User;
import com.bizanaliza.library.service.AppException;
import com.bizanaliza.library.service.UserService;

@Path("/user")
public class UserResource {
	
	@EJB
	private UserService userService;

	//posto je ovo user klasa pravimo Logger sa kojim cemo verifikovati logovanje usera
	private static Logger logger = LoggerFactory.getLogger(UserResource.class);
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public UserResponse createUser(User user) {
		
		//logujemo poruku
		logger.info("Method executed!");
		
		UserResponse response = new UserResponse();
		
		try {
			User u = userService.createUser(user);
			response.setUser(u);
			response.setErrorCode(ErrorMessages.ok);
			return response;
			
		}catch(PersistenceException pe) {
			response.setErrorCode(ErrorMessages.db_problem);
			return response;
			
		}catch(AppException AppEx) {
			response.setErrorCode(AppEx.getError());
			return response;
		}
		
		
	}
}
