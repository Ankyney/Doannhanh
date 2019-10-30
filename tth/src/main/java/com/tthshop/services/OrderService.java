package com.tthshop.services;

import java.util.List;

import com.tthshop.entities.Order;
import com.tthshop.entities.Report;

public interface OrderService {
//danh sach don hang
	Iterable<Order> findAll();

// danh sach don hang moi
	List<Order> getNewOrder();

// danh sach don hang da thanh toan
	List<Order> getCheckedOrder();

//tim don hang bang id
	Order findOne(int id);

// them don hang moi
	void save(Order order);

// cap nhat don hang
	void update(Order order);

// danh sach so san pham duoc mua theo danh muc san pham
	List<Report> getOrderByCategory();

}
