package com.bizanaliza.library.rest;

public class ErrorMessages {

	
	private int code;
	private String message;
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// Kada ne zelimo da neko drugi napravi objekat klase, pravimo Private konstruktor
	private ErrorMessages(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public static final ErrorMessages ok = new ErrorMessages(0, "Operation successfull");
	
	//sve probleme sa bazom oznacicemo sa 100
	public static final ErrorMessages db_problem = new ErrorMessages(100, "Database Error");
	
	//ako je ime duze od 50 karaktera
	public static final ErrorMessages category_name_tooLong = new ErrorMessages(200, "Category exceeds 50 chars");
	
	//greske sa inputima
	public static final ErrorMessages category_name_exist = new ErrorMessages(201, "Category with given name exist in DB");
	
	//ako kategorija ne postoji
	public static final ErrorMessages category_do_not_exist = new ErrorMessages(202, "Category with give ID do not exists");
	
	//greska sa query string
	public static final ErrorMessages invalid_query_string = new ErrorMessages(203, "Query string is not properly formed");
	
	//greska sa id-em
	public static final ErrorMessages resource_dont_exist = new ErrorMessages(204, "Resource with given ID do not exist");
	
	//predugacko ime
	public static final ErrorMessages author_name_too_long = new ErrorMessages(301, "Author name is too long");
	
	//prdugacko prezime
	public static final ErrorMessages author_surname_too_long = new ErrorMessages(301, "Author surname is too long");
	
	//autor postoji
	public static final ErrorMessages author_already_exists = new ErrorMessages(301, "Author with that name and surname already exists");
	
	//autor ne postoji za get metod
	public static final ErrorMessages author_do_not_exists = new ErrorMessages(301, "Author with that name and surname do not  exists");

	
}
