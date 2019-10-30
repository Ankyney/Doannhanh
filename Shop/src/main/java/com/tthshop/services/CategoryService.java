package com.tthshop.services;

import java.util.List;

import com.tthshop.entities.Category;

public interface CategoryService {
	// danh sach danh muc san pham
	Iterable<Category> findAll();

// danh sach danh muc sp duoc tim bang ten danh muc
	List<Category> search(String q);

// tim danh muc bang id
	Category findOne(int id);

// them danh muc
	void save(Category category);

// xoa danh muc
	void delete(int id);

// kiem tra ten danh muc da ton tai
	boolean findCategoryByName(String name);

}
