package com.fairy.bookonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fairy.bookonline.entity.Book;


//子订单类
//与Book 一对一
//与Orders 多对一
@Entity
public class OrdersItem {
	private int id ;//流水号
	private Book book;//对应的书 (noe to noe)
	private int number = 0;//购买的书的数量
	private int price;//购买对应数量书的总价
	
	public OrdersItem() {}

	public OrdersItem(int id, Book book, int number, int price) {
		this.id = id;
		this.book = book;
		this.number = number;
		this.price = price;
	}
	public OrdersItem(Book book, int number) {//price 自动计算
		this.book = book;
		this.number = number;
		this.price = this.book.getPrice()*this.number;
	}
	
	@Id
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id",strategy="increment")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@OneToOne
	@JoinColumn(name="bookid")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
		this.setPrice();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
		if(this.book!=null)
			this.setPrice();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public void setPrice() {
		this.price = book.getPrice()*number;
	}
	
	
}



















