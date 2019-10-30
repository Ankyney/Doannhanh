package com.tthshop.services;

import java.util.List;

import com.tthshop.entities.Admin;

public interface AdminService {
// danh sach tai khoan admin
	Iterable<Admin> findAll();

// tim tai khoan admin bang id	
	Admin findOne(int id);

//tim tk admin bang ten tk
	Admin findByName(String name);

// tim tk admin bang mail
	Admin findByMail(String mail);

// kiem tra ten tk da ton tai chua
	boolean findAdminByName(String name);

	// kiem tra email da duoc dang ki chua
	boolean findAdminByEmail(String email);

// them tk moi
	void save(Admin Admin);

// cap nhat tai khoan
	void update(Admin Admin);

// xoa tai khoan
	void delete(int id);

}
