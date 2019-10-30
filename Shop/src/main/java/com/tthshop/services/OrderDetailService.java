package com.tthshop.services;

import java.util.List;

import com.tthshop.entities.OrderDetail;

public interface OrderDetailService {
// danh sach chi tiet don hang tim bang id
	List<OrderDetail> findByOrderID(int id);
	// them chi tiet don hang
	void save(OrderDetail orderDetail);
	// cap nhat danh sach don hang
	void update(OrderDetail orderDetail);

}
