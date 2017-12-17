package com.fairy.bookonline.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairy.bookonline.entity.Book;
import com.fairy.bookonline.entity.Orders;
import com.fairy.bookonline.entity.OrdersItem;
import com.fairy.bookonline.entity.UserInfo;

@Repository
public class OrdersDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	/*seve*/
	public void save(Orders orders,Session session) {
//		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务	
		session.save(orders);
		tra.commit();
	}
	
	/*get*/ //需要get么？
	public Orders getById(int id ) {
//		Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		Orders orders = session.get(Orders.class, id);
		tra.commit();
//		session.close();
		return orders;
	}
	/* getAllList*/
	public List<Orders> getAllList(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Orders");
		return q.list();
	}
	
	/* getListByUserinfo*/
	public List<Orders> getListByUserInfo(UserInfo userInfo){
		List<Orders> list = new ArrayList<Orders>();
		List<Orders> list1 = this.getAllList();
		for(Orders ord : list1) {
			if(ord.getUserInfo().getId()==userInfo.getId()) {//equals
				list.add(ord);
			}
		}
		return list;
	}
	
	/*update*/
	public void updateByOrders(Orders orders) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		session.update(orders);
		tra.commit();
	}
	/*delet*/
	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		Orders orders = session.get(Orders.class, id);
		session.delete(orders);
		tra.commit();
	}
}












