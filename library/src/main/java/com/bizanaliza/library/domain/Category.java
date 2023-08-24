package com.bizanaliza.library.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
//kada ne zelimo da dovlacimo informacije iz nekog atribut
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;

	//na ovaj nacin kazemo da je atribut Books nebitan za XML i necemo ga dohvatati
	@XmlTransient
	@OneToMany(mappedBy = "category")
	private Set<Book> books;
	
	
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
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	

}
