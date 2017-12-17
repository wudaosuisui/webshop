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
	
    /*生成订单*/
	@RequestMapping("/produceorders")
	public String produceOrders(
//			@RequestParam("i") int[] iList,
			@RequestParam(value = "i", required = false) int[] iList,
			@RequestParam("sub") String sub,
			HttpSession session,
			HttpServletRequest request ) {
		if(sub.equals("支付选中商品")) {//只支付部分商品
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
		orders.setPrice();//自动计算总价格
		this.ordersServiceImpl.save(orders,session);//将建立好的orders 和session交给 service进行后续处理
		return "Shop/Orders";
	}
	/*添加一本书*/
	@RequestMapping("/addone")
	public String addOne(
			@RequestParam("i")int i ,
			@RequestParam("bookId")int bookId,
			HttpSession session) {
		this.ordersServiceImpl.addOne(bookId,i,session);
		return "Shop/Cart";
	}
	/*减少一本书*/
	@RequestMapping("/cutone")
	public String cutOne(
			@RequestParam("i")int i ,
			@RequestParam("bookId")int bookId,
			HttpSession session) {
		this.ordersServiceImpl.cutOne(bookId,i,session);
		return "Shop/Cart";
	}
	/*支付*/
	@RequestMapping("/gotopay")
	public String	goToPay(HttpSession session) {
		return "Shop/payPage";
	}
	/*输入密码后的处理*/
	@RequestMapping("/havepay")
	public String	havePay(HttpSession session) {
		this.ordersServiceImpl.havePay(session);
		return "Shop/paySuccess";
	}
	//保存订单
	
//	//往购物车中 添加商品（子订单）
//	@RequestMapping("/addItem")
//	public String addItem(@RequestParam("book") Book book,
//			HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		UserInfo userInfo = (UserInfo)session.getAttribute("UserInfo");
//		return "";
//	}
}
