package ankyney.shop.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ankyney.shop.entities.Admin;
import ankyney.shop.repository.AdminRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository AdminRepo;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Iterable<Admin> findAll() {
		// TODO Auto-generated method stub
		return AdminRepo.findAll();
	}

	


	@Override
	public void save(Admin Admin) {
		// TODO Auto-generated method stub
		AdminRepo.save(Admin);
	}

	
	@Override
	public void update(Admin Admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tst = session.beginTransaction();
		try {
			session.update(Admin);
			tst.commit();
		} catch (Exception e) {
			tst.rollback();
		} finally {
			session.close();
		}
	}

	
	@Override
	public Admin findByName(String name) {
		// TODO Auto-generated method stub
		String hql = "FROM Admin WHERE username = '" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Admin) query.list().get(0);
	}
	@Override
	public boolean findAdminByName(String name) {
		// TODO Auto-generated method stub
		String hql = "FROM Admin WHERE username = '" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list().isEmpty()) return false;
		return true;
	}

	@Override
	public boolean findAdminByEmail(String email) {
		String hql = "FROM Admin WHERE mailaddress = '" + email + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list().isEmpty()) return false;
		return true;
	}

	@Override
	public Admin findByMail(String mail) {
		// TODO Auto-generated method stub
		String hql = "FROM Admin WHERE mailaddress = '" + mail + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Admin) query.list().get(0);
	}




	@Override
	public Admin findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
