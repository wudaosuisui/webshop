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
		//���֮ǰ�ж���  ����ɾ��
		Orders sinOrders = (Orders)sessionh.getAttribute("orders");
		if(sinOrders!=null) { //sinOrder�����Ϊ��  ˵��֮ǰ�Ѿ��浽�����ݿ�����
			sessionh.removeAttribute("orders");
			this.ordersDaoImp.updateByOrders(sinOrders);
		}
		//�ȴ��Ӷ���
		this.ordersItemDaoImpl.saveList(orders.getItem(),session);
		//�ٴ涩��
		this.ordersDaoImp.save(orders,session);
		sessionh.setAttribute("orders", orders);//�滻��֮ǰ�Ķ���
		session.close();
	}
	/*HavePay*/  //ɾ�����ﳵ�� �Ѿ����������
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
	
	/*�������� ���һ����*/
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
	/*�������� ����һ����*/
	public void cutOne(int bookId,int i ,HttpSession sessionh) {
		Session session = sessionFactory.openSession();
		UserInfo u = (UserInfo)sessionh.getAttribute("userInfo");//��ȡUserInfo
		List<Book> bookList = u.getCart();//��ȡCart
		Book rbook = this.bookDaoImpl.getById(bookId);
		for(Book book: bookList) {//ѭ���Ƴ� Ҫ���ٵ��Ǳ���
			if(book.getId()==rbook.getId()) {
				System.out.println("remove book "+book.getName());
				bookList.remove(book);//ò�ƿ�������д
				break;
			}
		}
		u.setCart(bookList);//��Cart ����userInfo��
//		sessionh.setAttribute("userInfo", u);//����userInfo�� session �е�����
		List<OrdersItem> ItemList = (List<OrdersItem>)sessionh.getAttribute("ItemList");//��ȡsession �е� ItemList 
		if(ItemList.get(i).getNumber()>1)//���������ĸ���
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
	
//	//��Ӷ���
//	public void save(Orders orders) {//��֪���Ӷ����Ǳ��Ƿ�������
//		//�ȴ��Ӷ���
//		this.ordersItemDaoImpl.saveList(orders.getItem());
//		//�ٴ涩��
//		this.ordersDaoImp.save(orders);
//	}
	//��ȡ���� list
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











