package com.bizanaliza.library.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryService {

	@PersistenceContext
	private EntityManager em;
	
}
