package com.fairy.bookonline.dao;

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

@Repository
public class OrdersItemDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	/*save*/
	public void save(OrdersItem ordersItem,Session session) {
		Transaction tra = session.beginTransaction();//开启事务
		session.save(ordersItem);
//		session.flush();
		tra.commit();
	}
	
	/*saveList*/
	public void saveList(List<OrdersItem> list,Session session) {
//		Session session = sessionFactory.getCurrentSession();
		for(OrdersItem t : list) 
			this.save(t,session);
	}
	
	/*get*/
	/*getAll*/
	public List<OrdersItem> getAllList(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from OrdersItem");
		return q.list();
	}
	/*getListByOrder*/
	public List<OrdersItem> getListByOrder(Orders orders){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from OrdersItem");
		//执行了一些筛选操作 或者上面执行HQL语句
		return q.list();
	}
	//update
	/*delet*/
	public void deleteItem(OrdersItem item) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		session.delete(item);
		tra.commit();
	}
	/* delete List*/
	public void deleteList(List<OrdersItem> list) {
		for(OrdersItem t : list) 
			this.deleteItem(t);
	}
}
