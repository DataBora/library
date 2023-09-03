package com.bizanaliza.library.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bizanaliza.library.domain.Author;
import com.bizanaliza.library.domain.AuthorQueries;
import com.bizanaliza.library.rest.ErrorMessages;
import com.bizanaliza.library.utils.AttributeLengthValidation;

@Stateless
public class AuthorService {

	@PersistenceContext
	private EntityManager em;
	
	//post metod
	public Author createAuthor(Author author) {
		
		AttributeLengthValidation.checkLenght(author.getName(), 30);
		AttributeLengthValidation.checkLenght(author.getSurname(), 30);

		if (AuthorQueries.authorExists(em, author.getName(), author.getSurname())) {
	        throw new AppException(ErrorMessages.author_already_exists);
	    }
		
		em.persist(author);
		return author;
		
	}
	
	//get metod za full stringove
	public Author getAuthor(String name, String surname, boolean like) {
		
		Author a = AuthorQueries.findAuthor(em, name, surname, like);
		
		if(a == null) {
			throw new AppException(ErrorMessages.author_do_not_exists);
		}
		return a;
		
	}
	
	//get method za id
	public Author getAuthorByID(long id) {
		
		Author a = AuthorQueries.getAuthorByID(em, id);
		
		if(a == null) {
			throw new AppException(ErrorMessages.author_do_not_exists);
		}
		return a;
		
	}
	
	
	//put method
	public Author updateAuthor(long id, Author updatedAuthor) {
		
		AttributeLengthValidation.checkLenght(updatedAuthor.getName(), 30);
		AttributeLengthValidation.checkLenght(updatedAuthor.getSurname(), 30);

	    Author existingAuthor = AuthorQueries.getAuthorByID(em, id);

	    if (existingAuthor == null) {
	        throw new AppException(ErrorMessages.author_do_not_exists); // or handle as needed
	    }

	    existingAuthor.setName(updatedAuthor.getName());
	    existingAuthor.setSurname(updatedAuthor.getSurname());

	    return existingAuthor;
	}
	
	//delete method
	public void deleteAuthor(long id) {
		Author existingAuthor = AuthorQueries.getAuthorByID(em, id);
		
		if(existingAuthor == null) {
			throw new AppException(ErrorMessages.author_do_not_exists);
		}
		
		em.remove(existingAuthor);
	}
}
