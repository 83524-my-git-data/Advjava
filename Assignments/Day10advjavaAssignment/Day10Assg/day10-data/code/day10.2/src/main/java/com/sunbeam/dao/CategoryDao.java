package com.sunbeam.dao;

import com.sunbeam.entities.Category;

public interface CategoryDao {
//add a new category
	String addNewCategory(Category category);
	Category getCategoryDetailsByName(String categoryName);
}
