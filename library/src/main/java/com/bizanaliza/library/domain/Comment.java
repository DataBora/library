package com.bizanaliza.library.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="com_seq")
	@SequenceGenerator(name = "com_seq", sequenceName = "com_seq", initialValue = 1, allocationSize=1)
	@Column(name="ID")
	private long id;
	
	private String content;
	
	@ManyToOne
	private Book book;
	
	@ManyToOne
	private User users;
	
	
	
	//---------- Getters Setters ----------//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
