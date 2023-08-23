package com.bizanaliza.library.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CategoryQueries {
	
	public static Category findByName(EntityManager em, String name) {
		
		String q = "select c from Category c where c.name = :name";
		
		TypedQuery<Category> query = em.createQuery(q, Category.class); 
		query.setParameter("name", name);
		
		List<Category> c = query.getResultList();
		
		if(c.isEmpty()) return null;
		return c.get(0);
	}

}
