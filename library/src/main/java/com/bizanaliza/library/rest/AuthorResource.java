package com.bizanaliza.library.rest;

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

import com.bizanaliza.library.domain.Author;
import com.bizanaliza.library.service.AppException;
import com.bizanaliza.library.service.AuthorService;

@Path("author")
public class AuthorResource {
	
	@EJB
	private AuthorService authorService;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public AuthorResponse createAuthor(Author author) {
		
		AuthorResponse response = new AuthorResponse();
		
		try {
			Author a = authorService.createAuthor(author);
			
			response.setAuthor(a);
			response.setErrorCode(ErrorMessages.ok);
			return response;
			
		}catch (PersistenceException pe) {
			//kad uhvati error
			response.setErrorCode(ErrorMessages.db_problem);
			return response;
		} catch (AppException appEx) {
			response.setErrorCode(appEx.getError());
			return response;
		}
		
	}
	
	
	@GET
	@Produces("application/json")
	public AuthorResponse findAuthor(@QueryParam("name") String nameParam,
														  @QueryParam("surname") String surnameParam,
														  @QueryParam("like") boolean likeParam) {
		
		AuthorResponse response = new AuthorResponse();
		
		try {
			Author a = authorService.getAuthor(nameParam, surnameParam, likeParam);
			response.setAuthor(a);
			return response;
			
		}catch (PersistenceException pe) {
			response.setErrorCode(ErrorMessages.db_problem);
			return response;
			
		} catch (AppException appEx) {
			response.setErrorCode(appEx.getError());
			return response;
		}
		
	}
	
	//GET helper sa ID-em za PUT
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public AuthorResponse getAuthor(@PathParam("id") long id) {
		
		AuthorResponse response = new AuthorResponse();
		
		try {
			
			Author a = authorService.getAuthorByID(id);
			response.setAuthor(a);
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
	
	
	//PUT rest za menjanje resursa po id-u
	@PUT
	@Path("{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public AuthorResponse updateAuthor(@PathParam("id") long id, Author author) {
		
		AuthorResponse response = new AuthorResponse();
		
		try {
			Author c = authorService.updateAuthor(id, author);
			response.setAuthor(c);
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
	
	//brisanje autora
	@DELETE
	@Path("{id}")
	public RESTResponse deleteAuthor(@PathParam("id") long id) {
		
		RESTResponse response = new RESTResponse();
		
		try {
			authorService.deleteAuthor(id);
			response.setErrorCode(ErrorMessages.ok);
			return response;
			
		} catch(PersistenceException pe) {
			response.setErrorCode(ErrorMessages.db_problem);
			return response;
			
		} catch(AppException AppEx) {
			response.setErrorCode(AppEx.getError());
			return response;
			
		}
		
		
	}
	

}
