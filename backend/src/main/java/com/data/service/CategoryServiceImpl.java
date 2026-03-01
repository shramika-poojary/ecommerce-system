package com.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.exception.ResourceNotFoundException;
import com.data.model.Category;
import com.data.repository.CategoryRepository;

import lombok.Data;

@Service
@Data
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository repo;
	@Override
	public Category createCategory(Category category) {
		Category data=repo.save(category);
		return data;
	}

	@Override
	public Category updateCategory(Category category, int categoryId) {
		Optional<Category> existing=repo.findById(categoryId);
		existing.get().setCategoryName(category.getCategoryName());
		existing.get().setDescription(category.getDescription());
		existing.get().setStatus(category.getStatus());
		return repo.save(existing.get());
		
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> categories=repo.findAll();
		
		return categories;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		Optional<Category> data=repo.findById(categoryId);
		if(data.isPresent()) {
		return data.get();
		}else {
			throw new ResourceNotFoundException("No Such Category");
		}
	}

	@Override
	public Category deactivateCategory(int categoryId,boolean Status) {
		Optional<Category> category=repo.findById(categoryId);
		if(category.isPresent()) {
		 	category.get().setStatus(Status);
		 	return repo.save(category.get());
			
		}else {
			throw new ResourceNotFoundException("No Such Category");
		}
		
	}

	
	
}
