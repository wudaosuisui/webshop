package com.fairy.bookonline.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.fairy.bookonline.entity.Page;
import com.fairy.bookonline.entity.Book;

public class PageServiceImpl {
	private Page page;
//	private Page<Book> page;
	
	/*���б��ҳ*/
	public void pageSet(int page1,HttpSession session) {
		List<Book> bookList =(List<Book>) session.getAttribute("bookList");//��ȡbookList
//		Page<Book> page1 = new Page(12,bookList.size());
		page.setList(bookList);
		page.setCurrentPageNum(page1);
		page.setPageSize(12);
		page.setTotalCount(bookList.size());
		session.setAttribute("bookListPart", page.getList());
	}
	
	
	
}
