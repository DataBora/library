package com.bizanaliza.library.rest;

import javax.ejb.EJB;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bizanaliza.library.domain.Category;
import com.bizanaliza.library.service.AppException;
import com.bizanaliza.library.service.CategoryService;

@Path("category")
public class CategoryResource {
	
	@EJB
	private CategoryService categoryService;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public CreateCategoryResponse createCategory(Category category) {
		
		CreateCategoryResponse response = new CreateCategoryResponse();
		
		try {
			Category c = categoryService.createCategory(category);
			
			response.setCategory(c);
			//kad je sve ok
			response.setErrorCode(ErrorMessages.ok);
			
			return response;
			
		} catch (PersistenceException pe) {
			//kad uhvati error
			response.setErrorCode(ErrorMessages.db_problem);
			return response;
		} catch (AppException appEx) {
			response.setErrorCode(appEx.getError());
			return response;
		}
		
	}

}
