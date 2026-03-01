package com.data.service;

import java.util.List;

import com.data.model.Category;

public interface CategoryService {
	Category createCategory(Category category);
	Category updateCategory(Category category,int categoryId);
	List<Category> getAllCategory();
	Category getCategoryById(int categoryId);
	
	Category deactivateCategory(int categoryId, boolean Status);
	
	
}
