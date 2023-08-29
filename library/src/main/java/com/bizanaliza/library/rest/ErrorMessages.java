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
	
	//greska sa query string
	public static final ErrorMessages invalid_query_string = new ErrorMessages(202, "Query string is not properly formed");
	
	//greska sa id-em
	public static final ErrorMessages resource_dont_exist = new ErrorMessages(203, "Resource with given ID do not exist");
	
}
