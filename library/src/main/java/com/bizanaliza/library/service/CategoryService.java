package com.bizanaliza.library.service;

import java.util.List;

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
	
	//metod za creiranje kategorije po nazivu i hvatanje exceptiona ako kategorija postoji
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
	
	//metod za vracanje kategorija kroz query string
	public List<Category> getAll(String category, boolean like){
		
		List<Category> cs = CategoryQueries.getAll(em, category, like);
		
		return cs;
	}
	
	//metod za vracanje pojedinacnog resursa
	public Category getCategory(long id) {
		
		Category c = CategoryQueries.getCategory(em, id);
		
		if(c == null) {
			throw new AppException(ErrorMessages.resource_dont_exist);
		}
		return c;
	}
	
	//metod za update-ovanje resursa
	public Category updateCategory(long id, Category category) {
		
		 if (category.getName().length() > 50) {
		        throw new AppException(ErrorMessages.category_name_tooLong);
		    }

		    Category existingCategory = CategoryQueries.getCategory(em, id);

		    if (existingCategory == null) {
		        throw new AppException(ErrorMessages.category_do_not_exist); // or handle as needed
		    }

		    existingCategory.setName(category.getName());

		    return existingCategory;
	}
	
	//metoda za brisanje resursa
	public void deleteCategory(long id) {
		Category c = CategoryQueries.getCategory(em, id);
		
		if(c == null) {
			throw new AppException(ErrorMessages.resource_dont_exist);
		}
		
		em.remove(c);
	}
	
}
 