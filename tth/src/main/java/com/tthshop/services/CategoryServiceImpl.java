package com.tthshop.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tthshop.entities.Category;
import com.tthshop.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CategoryRepo cateRepo;

	@Override
	public Iterable<Category> findAll() {
		return cateRepo.findAll();
	}

	@Override
	public List<Category> search(String q) {
		return cateRepo.findByNameContaining(q);
	}

	@Override
	public Category findOne(int id) {
		return cateRepo.findOne(id);
	}

	@Override
	public void save(Category category) {
		cateRepo.save(category);
	}

	@Override
	public void delete(int id) {
		cateRepo.delete(id);
	}

	@Override
	public boolean findCategoryByName(String name) {
		// TODO Auto-generated method stub
		String hql = "FROM Category WHERE name = '" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (query.list().isEmpty())
			return false;
		return true;
	}
}
