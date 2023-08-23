package com.bizanaliza.library.rest;

import com.bizanaliza.library.domain.Category;

public class CreateCategoryResponse extends RESTResponse{

	private Category category;
	
	//------ GEtters Setters -----//

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
