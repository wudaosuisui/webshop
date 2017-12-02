package com.fairy.bookonline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="book")
public class Book {
	private int id ;//����
	private Category category;//����
	private String name;//����
	private String img ;//ͼƬ
	private String press;//������
	private String author ; //����
	private int price ;//�۸�
	private boolean sell;//�Ƿ��ϼ�
//	private String[] imgs;//����ҳ�� ͼƬ one to many ������
	//����
	public Book() {}
	
	public Book(String name, String press, String img,
			String author, int price,boolean sell) {
		//super();
//		this.id = id;
//		this.catgory = catgory;
		this.name = name;
		this.img = img;
		this.press = press;
		this.author = author;
		this.price = price;
		this.sell = sell;
	}

	//setter &getter 
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
	@JoinColumn(name="Category")//����ڱ�
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
