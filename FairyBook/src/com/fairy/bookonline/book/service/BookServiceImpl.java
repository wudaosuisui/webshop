package com.fairy.bookonline.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.fairy.bookonline.book.dao.BookDaoImpl;
import com.fairy.bookonline.entity.Book;

@Repository
public class BookServiceImpl {

	@Resource
	private BookDaoImpl bookDaoIml;
	
	//添加书籍
	public void Add(Book book) {
		this.bookDaoIml.save(book);
	}
	//修改书籍
	public void change(Book book) {
		this.bookDaoIml.update(book);
	}
	//删除书籍
	public void delete(Book book) {
		this.bookDaoIml.delete(book);
	}
	//id
	public void deleteById(int bookId) {
		this.bookDaoIml.deleteById(bookId);
	}
	//name
	public void deleteByName(String bookName) {
		this.bookDaoIml.deleteByName(bookName);
	}
	//获取书籍列表
	public List<Book> getList() {
		return this.bookDaoIml.getList();
	}

}
