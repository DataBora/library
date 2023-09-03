package com.bizanaliza.library.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="author_seq")
	@SequenceGenerator(name = "author_seq", sequenceName = "author_seq", initialValue = 1, allocationSize=1)
	@Column(name="ID")
	private long id;
	
	private String name;
	private String surname;
	
	@ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
	private Set<Book> books;
	
	//---------- Getters Setters ------------//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
}
