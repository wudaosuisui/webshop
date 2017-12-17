package com.fairy.bookonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="book")
public class Book {
	
	private int id ;//自增
	private Category category;//类型
	private String name;//书名
	private String img ;//图片
	private String press;//出版社
	private String author ; //作者
	private int price ;//价格
	private boolean sell;//是否上架
	
	public Book() {}
	
	public Book(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Book(String name, String press, String img,
			String author, int price,boolean sell) {

		this.name = name;
		this.img = img;
		this.press = press;
		this.author = author;
		this.price = price;
		this.sell = sell;
	}


	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="Category")//外键在表
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isSell() {
		return sell;
	}
	
	public void setSell(boolean sell) {
		this.sell = sell;
	}
	
	
}
