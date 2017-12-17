package com.fairy.bookonline.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairy.bookonline.dao.BookDaoImpl;
import com.fairy.bookonline.dao.OrdersDaoImpl;
import com.fairy.bookonline.dao.OrdersItemDaoImpl;
import com.fairy.bookonline.entity.Book;
import com.fairy.bookonline.entity.Orders;
import com.fairy.bookonline.entity.OrdersItem;
import com.fairy.bookonline.entity.UserInfo;

@Service
@Repository
public class OrdersServiceImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private OrdersDaoImpl ordersDaoImp;
	@Resource
	private OrdersItemDaoImpl ordersItemDaoImpl;
	@Resource
	private BookDaoImpl bookDaoImpl;
	
	
	
	/*save*/
	public void save(Orders orders,HttpSession sessionh) {
		Session session = sessionFactory.openSession();
		//如果之前有订单  将其删除
		Orders sinOrders = (Orders)sessionh.getAttribute("orders");
		if(sinOrders!=null) { //sinOrder如果不为空  说明之前已经存到过数据库中了
			sessionh.removeAttribute("orders");
			this.ordersDaoImp.updateByOrders(sinOrders);
		}
		//先存子订单
		this.ordersItemDaoImpl.saveList(orders.getItem(),session);
		//再存订单
		this.ordersDaoImp.save(orders,session);
		sessionh.setAttribute("orders", orders);//替换掉之前的订单
		session.close();
	}
	/*HavePay*/  //删除购物车里 已经购买的内容
	public void havePay(HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		Orders orders = (Orders)session.getAttribute("orders");
		List<Book> bookList = userInfo.getCart();
		List<OrdersItem> ItemList = orders.getItem();
		for(int i = 0 ; i<ItemList.size();i++) {
			for(int j = 0 ; j<bookList.size();j++) {
				if(bookList.get(j).getId() == ItemList.get(i).getBook().getId()) {
					bookList.remove(j);
					j--;
				}
			}
		}
		userInfo.setCart(bookList);
	}
	
	/*往订单中 添加一本书*/
	public void addOne(int bookId,int i ,HttpSession sessionh) {
		Session session = sessionFactory.openSession();
		UserInfo u = (UserInfo)sessionh.getAttribute("userInfo");
		List<Book> bookList = u.getCart();
		bookList.add(this.bookDaoImpl.getById(bookId));
		u.setCart(bookList);
		List<OrdersItem> ItemList = (List<OrdersItem>)sessionh.getAttribute("ItemList");
		ItemList.get(i).setNumber(ItemList.get(i).getNumber()+1);
		session.close();
	}
	/*往订单中 减少一本书*/
	public void cutOne(int bookId,int i ,HttpSession sessionh) {
		Session session = sessionFactory.openSession();
		UserInfo u = (UserInfo)sessionh.getAttribute("userInfo");//获取UserInfo
		List<Book> bookList = u.getCart();//获取Cart
		Book rbook = this.bookDaoImpl.getById(bookId);
		for(Book book: bookList) {//循环移除 要减少的那本书
			if(book.getId()==rbook.getId()) {
				System.out.println("remove book "+book.getName());
				bookList.remove(book);//貌似可以这样写
				break;
			}
		}
		u.setCart(bookList);//将Cart 存入userInfo中
//		sessionh.setAttribute("userInfo", u);//更新userInfo在 session 中的内容
		List<OrdersItem> ItemList = (List<OrdersItem>)sessionh.getAttribute("ItemList");//获取session 中的 ItemList 
		if(ItemList.get(i).getNumber()>1)//进行数量的更改
			ItemList.get(i).setNumber(ItemList.get(i).getNumber()-1);
		else
			ItemList.remove(i);
		session.close();
	}
	
	
	/*get*/
	
	/*getAllList*/
	public void getAllLisst(HttpServletRequest request) {
		Session session = sessionFactory.openSession();
		request.setAttribute("ordersList",this.ordersDaoImp.getAllList());
		session.close();
	}
	/*getListByUseInfo*/
	public void getListByUserInfo(UserInfo userInfo,HttpServletRequest request){
		Session session = sessionFactory.openSession();
		request.setAttribute("ordersList",this.ordersDaoImp.getListByUserInfo(userInfo));
		session.close();
	}
	/*getById*/
	public void getById(int id ,HttpServletRequest request ) {
		Session session = sessionFactory.openSession();
		request.setAttribute("orders",this.ordersDaoImp.getById(id));
		session.close();
	}
	/*update*/
	public void updateByOrders(Orders orders) {
		Session session = sessionFactory.openSession();
		this.ordersDaoImp.updateByOrders(orders);
		session.close();
	}
	
//	//添加订单
//	public void save(Orders orders) {//不知道子订单那边是否有问题
//		//先存子订单
//		this.ordersItemDaoImpl.saveList(orders.getItem());
//		//再存订单
//		this.ordersDaoImp.save(orders);
//	}
	//获取订单 list
//	public List<Orders> getListByUserInfo(UserInfo userInfo){
//		
//	}
	
//	//getById
//	public Orders getById(int id ) {
//		return this.ordersDaoImp.getById(id);
//	}
	
//	/*
//	 * getAllList
//	 * */
//	public List<Orders> getAllList(){
//		return this.ordersDaoImp.getAllList();
//	}
	
//	/*
//	 * getListByUserinfo
//	 * */
//	public List<Orders> getListByUserInfo(UserInfo userInfo){
//		return this.ordersDaoImp.getListByUserInfo(userInfo);
//	}
	/*
	 * upDateByOrders
	 * */
//	public void updateByOrders(Orders orders) {
//		this.ordersDaoImp.updateByOrders(orders);
//	}
	
	/*public void updateOrders(Orders orders) {
		
		// uuid orderUuid  status  10 
		
		
		// get order information 
		
		// get user information 
		
		// update the user money 
		
		// update the order status 
		
		
		//add wait send 
		
		// update 
	}*/
}











