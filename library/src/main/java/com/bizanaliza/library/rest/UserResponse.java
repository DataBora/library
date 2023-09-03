package com.bizanaliza.library.rest;

import com.bizanaliza.library.domain.User;

public class UserResponse extends RESTResponse{
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
