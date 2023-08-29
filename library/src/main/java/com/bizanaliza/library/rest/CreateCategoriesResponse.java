package com.bizanaliza.library.rest;

import java.util.List;

import com.bizanaliza.library.domain.Category;

public class CreateCategoriesResponse extends RESTResponse {
	
	private List<Category> categories;
	
	//------- GEtters Settets -------/////

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
}
