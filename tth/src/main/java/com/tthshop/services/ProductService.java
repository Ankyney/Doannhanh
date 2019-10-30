package com.tthshop.services;

import java.util.List;

import com.tthshop.entities.Report;
import com.tthshop.entities.Product;

public interface ProductService {
// danh sach tat ca san pham
	Iterable<Product> findAll();
// danh sach san pham tim theo ten
	List<Product> search(String q);
// danh sach san pham tim theo loai san pham
	List<Product> searchByCateID(int id);
// danh sach san pham tim theo khoang gia
	List<Product> SearchByPriceRange(long from, long to);
// danh sach san pham tim theo khoang gia va loai san pham
	List<Product> SearchByCateAndPriceRange(int id, long from, long to);
// tim sp theo id
	Product findOne(int id);
// tim sp thep ten
	Product findByName(String name);
// danh sach san pham ban nhieu nhat
	List<Product> getByBestSeller(int topNumber);
// danh sach san pham xem nhieu nhat
	List<Product> getByMostViews(int topNumber);
// them san pham moi
	void save(Product product);
// cap nhat san pham
	void update(Product product);
// xoa san pham
	void delete(int id);

	List<Product> forBlog();

	List<Report> productCategory();

}
