package com.fairy.bookonline.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;


@Entity
//@Table(name="user")
public class UserInfo {

    private int id;
    private UserLogin userLogin;
    private String name;//昵称
    private String slogan;//签名 
    private List<Book> Cart = new ArrayList<Book>();//购物车
    private List<Orders> orders;//订单列表 懒加载
    
    public UserInfo() {}
    
    public UserInfo( UserLogin userLogin,String name, String slogan) {//
//		super();
		this.userLogin = userLogin;
		this.name = name;
		this.slogan = slogan;
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


    @OneToOne
    @Cascade(value=CascadeType.ALL)
    @JoinColumn(name="UserLogin")
	public UserLogin getUserLogin() {
		return userLogin;
	}
    

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="Cart",//表名字
			joinColumns= {@JoinColumn(name="userInfoId")},
			inverseJoinColumns= {@JoinColumn(name="bookid")}
			)
	public List<Book> getCart() {
		return Cart;
	}

	public void setCart(List<Book> cart) {
		Cart = cart;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="userInfoId")
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
    
	

}
