package com.fairy.bookonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairy.bookonline.entity.Book;
import com.fairy.bookonline.entity.Category;

@Repository
public class CategoryDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	/*save*/
	public void save(Category category) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		session.save(category);
		session.flush();
		tra.commit();
	}
	/*get*/
	/*get List*/
	public List<Category> getList(){
		System.out.println("there is Category Dao  get List");
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Category");
		List<Category> cList = q.list();
		for(Category c : cList) {
			System.out.println("this Category name is : "+ c.getName());
		}
		return q.list();
	}
	/*get ById*/
	public Category getById(int id) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		Category category = session.get(Category.class, id);
		tra.commit();
		return category;
	}
	/*get byName*/
	public Category getByName(String CategoryName) {
		List<Category> list = getList();
		Category category = new Category();
		for(Category c : list) {
			if(c.getName().equals(CategoryName)) {
				category = c;
				break;
			}
		}
		return  category;
	}
	/*up Date*/
	public void upDate(Category category) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		session.update(category);
		session.flush();
		tra.commit();
	}
	/*delete*/
	public void delete(Category category) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		session.delete(category);
		tra.commit();
	}
	/*By id*/
	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		Category category = session.get(Category.class, id);
		session.delete(category);
		tra.commit();
	}
	/*by Name*/
	public void deleteByName(String categoryName) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		Category category = getByName(categoryName);
		session.delete(category);
		tra.commit();
	}
}
















