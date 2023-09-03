package com.bizanaliza.library.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserQueries {

	public static boolean emailExists(EntityManager em,String email) {
		
		String q = "select u from User u where u.email = :email";
		
		TypedQuery<User> query = em.createQuery(q, User.class);
		query.setParameter("email", email);
		
		List<User> users = query.getResultList();
		
		if(users.size() == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean usernameExists(EntityManager em, String username) {
		
		String q  = "select u from User u where u.username = :username";
		
		TypedQuery<User> query = em.createQuery(q,User.class);
		query.setParameter("username", username);
		
		List<User> users = query.getResultList();
		
		if(users.size() == 0) {
			return false;
		}else {
			return true;
		}
		
	}
}
