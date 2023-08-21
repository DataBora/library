package com.bizanaliza.library.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CoverImage {
	
	@Id
	private long id;
	
	private byte[] content;
	private ImageType imageType;
	
	@OneToOne //sa ovim proglasavamo da je CoverImage owner associjacije
	private Book book;
	
	
	
	
	//-------Getters Setters----------//
	
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public ImageType getImageType() {
		return imageType;
	}
	public void setImageType(ImageType imageType) {
		this.imageType = imageType;
	}
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	

}
