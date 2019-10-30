package com.tthshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tthshop.entities.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer> {

	List<Admin> findByNameContaining(String q);

}
