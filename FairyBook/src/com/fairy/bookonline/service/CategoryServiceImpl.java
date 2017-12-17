package com.fairy.bookonline.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairy.bookonline.dao.CategoryDaoImpl;
import com.fairy.bookonline.entity.Category;

@Service
@Repository
public class CategoryServiceImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private CategoryDaoImpl cateogryDaoImpl;
	
	//获取图书种类
	public void getList(HttpSession sessionh){
		Session session = sessionFactory.openSession();
		sessionh.setAttribute("cateogryList",this.cateogryDaoImpl.getList());
		session.close();
	}
	//getById
	public void getById(int id,HttpServletRequest request ) {
		Session session = sessionFactory.openSession();
		request.setAttribute("cateogry",this.cateogryDaoImpl.getById(id));
		session.close();
	}
	//getByName
	public void getByName(String CategoryName,HttpServletRequest request) {
		Session session = sessionFactory.openSession();
		request.setAttribute("cateogry",this.cateogryDaoImpl.getByName(CategoryName));
//		return this.cateogryDaoImpl.getByName(CategoryName);
		session.close();
	}
	//添加图书种类
	public void Add(Category category) {
		Session session = sessionFactory.openSession();
		this.cateogryDaoImpl.save(category);
		session.close();
	}
	//修改图书种类
	public void change(Category category) {
		Session session = sessionFactory.openSession();
		this.cateogryDaoImpl.upDate(category);
		session.close();
	}
	//删除图书种类
	public void delete(Category category) {
		Session session = sessionFactory.openSession();
		this.cateogryDaoImpl.delete(category);
		session.close();
	}
	//Id删除
	public void deleteById(int id ) {
		Session session = sessionFactory.openSession();
		this.cateogryDaoImpl.deleteById(id);
		session.close();
	}
	//Name删除
	public void deleteByName(String CategoryName) {
		Session session = sessionFactory.openSession();
		this.deleteByName(CategoryName);
		session.close();
	}
}







