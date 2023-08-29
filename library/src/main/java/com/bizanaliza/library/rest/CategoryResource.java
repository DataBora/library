package com.bizanaliza.library.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.bizanaliza.library.domain.Category;
import com.bizanaliza.library.service.AppException;
import com.bizanaliza.library.service.CategoryService;

@Path("category")
public class CategoryResource {
	
	@EJB
	private CategoryService categoryService;
	
	//keiranje kategrije
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public CategoryResponse createCategory(Category category) {
		
		CategoryResponse response = new CategoryResponse();
		
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
	
	
	//get protokol koji ce vratiti sve kategorije
	@GET
	@Produces("application/json")
	public CreateCategoriesResponse getAll(@QueryParam("category") String categoryParam,
															  @QueryParam("like") boolean likeParam) {
		
		CreateCategoriesResponse response = new CreateCategoriesResponse();
		
		try {
			List<Category> c = categoryService.getAll(categoryParam, likeParam);
			
			response.setCategories(c);
			return response;
			
		} catch (PersistenceException pe) {
			response.setErrorCode(ErrorMessages.db_problem);
			return response;
			
		} catch (AppException appEx) {
			response.setErrorCode(appEx.getError());
			return response;
		}
	}

	//get metod za dohvatanje pojedinacnog resursa uz pomoc id-a
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public CategoryResponse getCategory(@PathParam("id") long id) {
		
		CategoryResponse response = new CategoryResponse();
		
		try {
			
			Category c = categoryService.getCategory(id);
			response.setCategory(c);
			response.setErrorCode(ErrorMessages.ok);
			
			return response;
			
		}catch (PersistenceException pe) {
			response.setErrorCode(ErrorMessages.db_problem);
			return response;
			
		} catch (AppException appEx) {
			response.setErrorCode(appEx.getError());
			return response;
		}
	}
	
	//PUT metod za menjanje resursa
	@PUT
	@Path("{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public CategoryResponse updateCategory(@PathParam("id") long id,  Category category) {
		
		CategoryResponse response  = new CategoryResponse();
		
		try {
			Category c = categoryService.updateCategory(id, category);
			response.setCategory(c);
			response.setErrorCode(ErrorMessages.ok);
			
			return response;
			
			
		}catch (PersistenceException pe) {
			response.setErrorCode(ErrorMessages.db_problem);
			return response;
			
		} catch (AppException appEx) {
			response.setErrorCode(appEx.getError());
			return response;
		}
	}
	
	//delete metod za brisanje resursa
	@DELETE
	@Path("{id}")
	public RESTResponse deleteCategory(@PathParam("id") long id) {
		
		RESTResponse response = new RESTResponse();
		 try {
		        categoryService.deleteCategory(id);
		        response.setErrorCode(ErrorMessages.ok);
		        return response;
		        		
		 	}catch (PersistenceException pe) {
				response.setErrorCode(ErrorMessages.db_problem);
				return response;
				
			} catch (AppException appEx) {
				response.setErrorCode(appEx.getError());
				return response;
			}
		}
}
