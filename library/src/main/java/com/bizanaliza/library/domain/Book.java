package com.bizanaliza.library.domain;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="book_seq")
	@SequenceGenerator(name = "book_seq", sequenceName = "book_seq", initialValue = 1, allocationSize=1)
	@Column(name="ID")
	private long id;
	
	private String title;
	private String description;
	
	@Embedded
	private Isbn isbn;
	private Format format;
	
	@OneToOne(mappedBy = "book") //Book klasu proglasili referentnom i ona nece imati dodatnu kolonu vec CoverImage
	private CoverImage image;
	
	@ManyToOne
	private Category category;
	
	@ManyToMany
	private Set<Author> authors;
	
	@OneToMany(mappedBy = "book")
	private Set<Comment> comments;
	
	//---------- Getters Setters -------------//
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Isbn getIsbn() {
		return isbn;
	}
	public void setIsbn(Isbn isbn) {
		this.isbn = isbn;
	}
	public Format getFormat() {
		return format;
	}
	public void setFormat(Format format) {
		this.format = format;
	}
	public CoverImage getImage() {
		return image;
	}
	public void setImage(CoverImage image) {
		this.image = image;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
	
	
	
	
}
