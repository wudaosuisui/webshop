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
		//��ȡbook�б�
		List<Book> booklist= this.bookServiceImpl.getBookList();
		//����session
		HttpSession session = request.getSession();
		session.setAttribute("booklist", booklist);
		//ǰ����ҳ
		return "Shop/indext";
	}
}
