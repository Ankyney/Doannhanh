package com.tthshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tthshop.entities.Category;

public interface CategoryRepo extends CrudRepository<Category, Integer> {

	List<Category> findByNameContaining(String q);

}
