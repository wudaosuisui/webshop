package com.fairy.bookonline.book.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairy.bookonline.book.service.BookServiceImpl;
import com.fairy.bookonline.entity.Book;

@Repository
@RequestMapping("book")
public class BookController {
	@Resource
	private BookServiceImpl bookServiceImpl;
	
	//getList
	@RequestMapping("/indext")
	public String Shop(HttpServletRequest request) {
		//获取book列表
		List<Book> booklist= this.bookServiceImpl.getBookList();
		//存入session
		HttpSession session = request.getSession();
		session.setAttribute("booklist", booklist);
		//前往首页
		return "Shop/indext";
	}
}
