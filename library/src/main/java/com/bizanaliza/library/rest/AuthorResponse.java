package com.bizanaliza.library.rest;

import com.bizanaliza.library.domain.Author;

public class AuthorResponse extends RESTResponse{
	
	private Author author;
	
	//------ GEtters Setters -----//

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	

}
