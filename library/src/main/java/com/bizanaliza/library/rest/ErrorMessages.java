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
	
	//--------------------- DATABASE -------------------------//
	public static final ErrorMessages ok = new ErrorMessages(0, "Operation successfull");
	
	//sve probleme sa bazom oznacicemo sa 100
	public static final ErrorMessages db_problem = new ErrorMessages(100, "Database Error");
	
	//---------------------- CATEGORY -----------------------//
	//greske sa inputima
	public static final ErrorMessages category_name_exist = new ErrorMessages(201, "Category with given name exist in DB");
	
	//ako kategorija ne postoji
	public static final ErrorMessages category_do_not_exist = new ErrorMessages(202, "Category with give ID do not exists");
	
	//greska sa query string
	public static final ErrorMessages invalid_query_string = new ErrorMessages(203, "Query string is not properly formed");
	
	//greska sa id-em
	public static final ErrorMessages resource_dont_exist = new ErrorMessages(204, "Resource with given ID do not exist");

	//---------------------- AUTHOR -------------------------//
	//autor postoji
	public static final ErrorMessages author_already_exists = new ErrorMessages(301, "Author with that name and surname already exists");
	
	//autor ne postoji za get metod
	public static final ErrorMessages author_do_not_exists = new ErrorMessages(302, "Author with that name and surname do not  exists");
	
	//----------------------- USER --------------------------//
	//attribute too long
	public static final ErrorMessages attribute_too_long = new ErrorMessages(400, "Attribute is longer then 30 characters");
	
	//user name exists
	public static final ErrorMessages user_name_exists = new ErrorMessages(401, "User with that name  exists");
	
	//user surname exists
	public static final ErrorMessages user_surname_exists = new ErrorMessages(402, "User with that surname exists");
	
	//user email
	public static final ErrorMessages invalid_email_format = new ErrorMessages(403, "Email format is not valid");
	//email exists
	public static final ErrorMessages user_email_exists = new ErrorMessages(404, "Email already exists");
	
	//user username exists
	public static final ErrorMessages user_username_exists= new ErrorMessages(405, "Username already taken");

	//user password invalid
	public static final ErrorMessages user_password_invalid = new ErrorMessages(406, "Psssword is invalid, need to have at least 1 number, 1 sign, 1 capital letter");
	
}
