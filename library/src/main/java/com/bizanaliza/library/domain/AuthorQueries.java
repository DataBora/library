package com.bizanaliza.library.domain;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.bizanaliza.library.rest.ErrorMessages;
import com.bizanaliza.library.service.AppException;

public class AuthorQueries {

	//-------------------- za GET --------------//
	
	//GET Query koji ce vracati Autora po imenu i /ili prezimenu ili loosely mastch sa like param
	public static Author findAuthor(EntityManager em, String name, String surname, boolean like) {
		
		if (like && (name == null && surname == null)) {
	        throw new AppException(ErrorMessages.invalid_query_string);
	    }

	    String q = "select distinct a from Author a left join fetch a.books b";

	    if (name != null && surname != null) {
	        if (like) {
	            q += " where (a.name like concat('%', :name, '%') or a.surname like concat('%', :surname, '%'))";
	        } else {
	            q += " where a.name = :name and a.surname = :surname";
	        }
	    } else if (name != null) {
	        if (like) {
	            q += " where a.name like concat('%', :name, '%')";
	        } else {
	            q += " where a.name = :name";
	        }
	    } else if (surname != null) {
	        if (like) {
	            q += " where a.surname like concat('%', :surname, '%')";
	        } else {
	            q += " where a.surname = :surname";
	        }
	    } else {
	        throw new AppException(ErrorMessages.invalid_query_string);
	    }

	    TypedQuery<Author> query = em.createQuery(q, Author.class);

	    if (name != null) {
	        query.setParameter("name", name);
	    }
	    if (surname != null) {
	        query.setParameter("surname", surname);
	    }

	    try {
	        Author author = query.getSingleResult();
	        // Initialize the books collection
	        if (author != null) {
	            author.getBooks().size();
	        }
	        return author;
	    } catch (NoResultException e) {
	        return null; // Return null if no result is found
	    }
	    
	    
	    
	}
	
	
	//--------------- za PUT -------------//
	
	//GET findByName za Name i Surname trazenje za PUT metod
	public static Author findByName(EntityManager em, String name, String surname) {
		
		String q = "select a from Author a where a.name = :name and a.surname = :surname";
		
		TypedQuery<Author> query = em.createQuery(q, Author.class); 
		query.setParameter("name", name);
		query.setParameter("surname", surname);
		
		try {
	        Author a = query.getSingleResult();
	        return a;
	    } catch (NoResultException e) {
	        return null; // No result found, return null
	    }
	}
	
	
	//----za GET, za PUT , za DELETE
	public static Author getAuthorByID(EntityManager em, long id) {
		return em.find(Author.class, id);
	}

	
	//------------------- za POST ----------------//
	
//POST helper metod za proveru da li autor postji pre kreiranja autora
	public static boolean authorExists(EntityManager em, String name, String surname) {
	    String q = "SELECT COUNT(a) FROM Author a WHERE a.name = :name AND a.surname = :surname";
	    
	    TypedQuery<Long> query = em.createQuery(q, Long.class);
	    query.setParameter("name", name);
	    query.setParameter("surname", surname);
	    
	    return query.getSingleResult() > 0;
	}
	
	//----- za DELETE ----//
	
	
}
