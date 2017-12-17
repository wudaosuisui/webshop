package com.fairy.bookonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairy.bookonline.entity.Book;

@Repository
public class BookDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/*save*/
	
	public void save(Book book) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		session.save(book);
		session.flush();
		tra.commit();
	}
	
	/*get*/
	
	/*get List*/
	public List<Book> getList(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Book");
		return q.list();
	}
	/*get Byid*/
	public Book getById(int id) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		Book book = session.get(Book.class, id);
//		session.flush();
		tra.commit();
		return book;
	}
	
	/*get ByName*/
	public Book getByName(String bookName) {
		List<Book> list = getList();
		Book book = new Book();
		for(Book b : list) {
			if(b.getName().equals(bookName)) {
				book = b;
				break;
			}
		}
		return book;
	}
	
	
	/*update*/
	public void update(Book book) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		session.update(book);
		session.flush();
		tra.commit();
	}
	
	
	/*delete*/
	
	public void delete(Book book) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		session.delete(book);
		session.flush();
		tra.commit();
	}
	/*delete byId*/
	public void deleteById(int id ) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		Book book2 = session.get(Book.class, id);
		session.delete(book2);
		tra.commit();
	}
	/*delete ByName*/
	public void deleteByName(String bookName) {
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Book");
		List<Book> list = q.list();
		Book book = new Book();
		for(Book b : list) {
			if(b.getName().equals(bookName)) {
				book = b;
				break;
			}
		}
		delete(book);
	}
	
}


