package com.fairy.bookonline.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fairy.bookonline.entity.Book;
import com.fairy.bookonline.entity.Orders;
import com.fairy.bookonline.entity.OrdersItem;
import com.fairy.bookonline.entity.UserInfo;
import com.fairy.bookonline.service.OrdersServiceImpl;

@Controller
@Repository
@RequestMapping("orders")
public class OrdersController {
	@Resource
	private OrdersServiceImpl ordersServiceImpl;
	@Resource
	private BookController bookContrller;
	
    /*���ɶ���*/
	@RequestMapping("/produceorders")
	public String produceOrders(
//			@RequestParam("i") int[] iList,
			@RequestParam(value = "i", required = false) int[] iList,
			@RequestParam("sub") String sub,
			HttpSession session,
			HttpServletRequest request ) {
		if(sub.equals("֧��ѡ����Ʒ")) {//ֻ֧��������Ʒ
//			if(session.getAttribute("ItemList")!=null)
//				session.removeAttribute("ItemList");
			List<OrdersItem> ItemS = new ArrayList<OrdersItem>();
			List<OrdersItem> ItemList  = (List<OrdersItem>)session.getAttribute("ItemList");
			for(int i : iList) 
				ItemS.add(ItemList.get(i));
			session.setAttribute("ItemList", ItemS);
		}
		List<OrdersItem> ItemList  = (List<OrdersItem>)session.getAttribute("ItemList");
		Orders orders = new Orders(new Date(),ItemList,(UserInfo)session.getAttribute("userInfo"));
		orders.setPrice();//�Զ������ܼ۸�
		this.ordersServiceImpl.save(orders,session);//�������õ�orders ��session���� service���к�������
		return "Shop/Orders";
	}
	/*���һ����*/
	@RequestMapping("/addone")
	public String addOne(
			@RequestParam("i")int i ,
			@RequestParam("bookId")int bookId,
			HttpSession session) {
		this.ordersServiceImpl.addOne(bookId,i,session);
		return "Shop/Cart";
	}
	/*����һ����*/
	@RequestMapping("/cutone")
	public String cutOne(
			@RequestParam("i")int i ,
			@RequestParam("bookId")int bookId,
			HttpSession session) {
		this.ordersServiceImpl.cutOne(bookId,i,session);
		return "Shop/Cart";
	}
	/*֧��*/
	@RequestMapping("/gotopay")
	public String	goToPay(HttpSession session) {
		return "Shop/payPage";
	}
	/*���������Ĵ���*/
	@RequestMapping("/havepay")
	public String	havePay(HttpSession session) {
		this.ordersServiceImpl.havePay(session);
		return "Shop/paySuccess";
	}
	//���涩��
	
//	//�����ﳵ�� �����Ʒ���Ӷ�����
//	@RequestMapping("/addItem")
//	public String addItem(@RequestParam("book") Book book,
//			HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		UserInfo userInfo = (UserInfo)session.getAttribute("UserInfo");
//		return "";
//	}
}
