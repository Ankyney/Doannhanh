package com.tthshop.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tthshop.entities.Order;
import com.tthshop.entities.Report;
import com.tthshop.repository.OrderRepo;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private SessionFactory factory;

	@Override
	public Iterable<Order> findAll() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public Order findOne(int id) {
		// TODO Auto-generated method stub
		return orderRepo.findOne(id);
	}

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		orderRepo.save(order);
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		orderRepo.save(order);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> getNewOrder() {
		// TODO Auto-generated method stub
		String hql = "FROM Order WHERE status = 0";
		return factory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> getCheckedOrder() {
		// TODO Auto-generated method stub
		String hql = "FROM Order WHERE status = 1";
		return factory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Report> getOrderByCategory() {
		List<Report> list = new ArrayList<Report>();
		String hql = "SELECT category.name as name,count(*) as num  FROM order_detail  INNER JOIN product on order_detail.product_id=product.id INNER join category ON product.cate_id=category.id group by category.name";
		SQLQuery query = factory.getCurrentSession().createSQLQuery(hql).addScalar("name", new StringType())
				.addScalar("num", new IntegerType());
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
			Report ord = new Report();
			ord.setname(row[0].toString());
			ord.setNum(Integer.parseInt(row[1].toString()));
			list.add(ord);
	
		}
		System.out.println(list.get(1).getname());
		return list;
		/* return .list(); */
	}

}
