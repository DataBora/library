package com.bizanaliza.library.rest;

import javax.ejb.EJB;
import javax.ws.rs.Path;

import com.bizanaliza.library.service.CategoryService;

@Path("category")
public class CategoryResource {
	
	@EJB
	private CategoryService categoryService;

}
