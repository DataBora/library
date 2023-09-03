package com.bizanaliza.library.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bizanaliza.library.rest.ErrorMessages;
import com.bizanaliza.library.service.AppException;

public class CategoryQueries {
	
	//Query za metod koji ce vracati kategoriju po nazivu
	public static Category findByName(EntityManager em, String name) {
		
		String q = "select c from Category c where c.name = :name";
		
		TypedQuery<Category> query = em.createQuery(q, Category.class); 
		query.setParameter("name", name);
		
		List<Category> c = query.getResultList();
		
		if(c.isEmpty()) return null;
		return c.get(0);
	}
	
	//Query za metod koji ce vracati kategorije spram odredjenih uslova
	public static List<Category> getAll(EntityManager em, String category, boolean like){
		
		if(like == true && category == null) {
			throw new AppException(ErrorMessages.invalid_query_string);
		}
		
		String q = "select c from Category c";
		
		if(category != null && like == false) {
			q += " where c.name= :name";
			
		} else if(category !=null && like == true){
			q += " where c.name like concat('%', :name ,'%')";
		}
		
		TypedQuery<Category> query = em.createQuery(q, Category.class);
		
		if(category != null) {
			query.setParameter("name", category);

		}
		
		return query.getResultList();
		
	}
	
	//query metod za vracanje jednog resursa
	public static Category getCategory(EntityManager em, long id) {
		
		return em.find(Category.class, id); 
		
	}

}
