package com.tthshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.tthshop.entities.Order;

public interface OrderRepo extends CrudRepository<Order, Integer>  {

}
