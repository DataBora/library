package com.bizanaliza.library.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bizanaliza.library.domain.Category;
import com.bizanaliza.library.domain.CategoryQueries;
import com.bizanaliza.library.rest.ErrorMessages;

@Stateless
public class CategoryService {

	@PersistenceContext
	private EntityManager em;
	
	public Category createCategory(Category category) {
		
		if(category.getName().length() > 50) {
			throw new AppException(ErrorMessages.category_name_tooLong);
		}
		
		Category c = CategoryQueries.findByName(em, category.getName());
		
		if(c != null) {
			throw new AppException(ErrorMessages.category_name_exist);
		}
		
		em.persist(category);
		return category;
	}
	
}
 
