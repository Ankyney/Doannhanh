package ankyney.shop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ankyney.shop.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

	List<Admin> findByNameContaining(String q);

}
