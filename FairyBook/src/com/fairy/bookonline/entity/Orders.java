package com.fairy.bookonline.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Orders {
	private int id ;//订单号
	private Date Time;//下单时间
	private List<OrdersItem> Item;//子订单列表  ont to many 单向
	private UserInfo userInfo;//用户  Many to one 双向
	private int price;//总价
	
	public Orders() {}

	public Orders(int id, Date time, List<OrdersItem> item,UserInfo userInfo) {
		this.id = id;
		Time = time;
		Item = item;
		this.userInfo = userInfo;
	}

	public Orders(Date time, List<OrdersItem> item,UserInfo userInfo) {
		Time = time;
		Item = item;
		this.userInfo = userInfo;
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

	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) {
		Time = time;
	}
	
	@OneToMany(fetch=FetchType.EAGER)//积极加载
    @Cascade(value=CascadeType.ALL)
	@JoinColumn(name="ordersid")
	public List<OrdersItem> getItem() {
		return Item;
	}

	public void setItem(List<OrdersItem> item) {
		Item = item;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userInfo")
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public void setPrice() {
		for(OrdersItem item : Item) {
			price += item.getPrice();
		}
	}
	
	
}
























