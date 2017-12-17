package com.fairy.bookonline.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairy.bookonline.dao.BookDaoImpl;
import com.fairy.bookonline.entity.Book;
import com.fairy.bookonline.entity.Page;
import com.fairy.bookonline.entity.UserInfo;

@Service
@Repository
public class BookServiceImpl {

	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private BookDaoImpl bookDaoImpl;
	
	
	
//	request.setAttribute("errorinfo", "查无此账号");
	//添加书籍
	public void Add(Book book) {
		Session session = sessionFactory.openSession();
		this.bookDaoImpl.save(book);
		session.close();
	}
	//修改书籍
	public void change(Book book) {
		Session session = sessionFactory.openSession();
		this.bookDaoImpl.update(book);
		session.close();
	}
	//删除书籍
	public void delete(Book book) {
		Session session = sessionFactory.openSession();
		this.bookDaoImpl.delete(book);
		session.close();
	}
	/*向购物车里添加图书*/
	/*BookToCart*/
	public void BookToCart(int bookid,UserInfo userInfo) {
		Session session = sessionFactory.openSession();
		userInfo.getCart().add(this.bookDaoImpl.getById(bookid));
		session.close();
	}
	//id
	public void deleteById(int bookId) {
		Session session = sessionFactory.openSession();
		 this.bookDaoImpl.deleteById(bookId);
		session.close();
	}
	//name
	public void deleteByName(String bookName) {
		Session session = sessionFactory.openSession();
		this.bookDaoImpl.deleteByName(bookName);
		session.close();
	}
	//获取书籍列表
	/*getList*/
	public void getList(HttpServletRequest request) {
		Session session = sessionFactory.openSession();
		HttpSession sessionh = request.getSession();
		Page page = (Page) sessionh.getAttribute("page");
		page.setList(this.bookDaoImpl.getList());
		sessionh.setAttribute("bookList",page.getPartList());
		session.close();
	}
	public Book getById(int id ) {//这个方法 貌似没什么实际用途
		Session session = sessionFactory.openSession();
		return this.bookDaoImpl.getById(id);//session.close() 放在了Dao
	}

}
