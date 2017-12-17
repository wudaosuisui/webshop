package com.fairy.bookonline.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fairy.bookonline.dao.CategoryDaoImpl;
import com.fairy.bookonline.entity.Book;
import com.fairy.bookonline.entity.Category;
import com.fairy.bookonline.entity.OrdersItem;
import com.fairy.bookonline.entity.Page;
import com.fairy.bookonline.entity.UserInfo;
import com.fairy.bookonline.service.BookServiceImpl;
import com.fairy.bookonline.service.CategoryServiceImpl;
import com.fairy.bookonline.service.PageServiceImpl;


@Controller
@Repository
@RequestMapping("book")
public class BookController {
	@Resource
	private BookServiceImpl bookServiceImpl;
	@Resource
	private CategoryServiceImpl categoryServiceImpl;
	@Resource
	private CategoryDaoImpl categoryDaoImpl;
	
	private Page page;
	/*跳转到图书展示页面前的处理*/
	@RequestMapping("/indext")
	public String Shop(//@RequestParam(value="pageN" ) int pageN,
			HttpServletRequest request) {
		this.bookServiceImpl.getList(request);//bookList 存入session
		return "Shop/shop";
	}
	/*上一页\下一页*/
	@RequestMapping("/changePageNum")
	public String changePageNum(@RequestParam(value="pageN" ) int pageN,HttpSession session,HttpServletRequest request) {
		Page page = (Page)session.getAttribute("page");
		page.setCurrentPageNum(pageN);
		session.setAttribute("page", page);
		return this.Shop(request);
	}

	/*跳转到添加图书页面前的处理*/
	@RequestMapping("/addpage")
	public String addPage(HttpSession session) {
		this.categoryServiceImpl.getList(session);
		return "BackGround/addbook";
	}

	/*添加图书*/
	@RequestMapping("/addbook")
	public String AddBook(@RequestParam("Name") String name,@RequestParam("Category") int cid,
			@RequestParam("Img") String img,@RequestParam("Press") String press,
			@RequestParam("Author") String author,@RequestParam("Price") int price,
			@RequestParam("Sell") Boolean sell,@RequestParam("button") String button,
			HttpServletRequest request) {
		if(button.equals("Back")) {
			return "BackGround/indext";
		}else {
			HttpSession session = request.getSession();
			Category category = this.categoryDaoImpl.getById(cid);
			Book book = new Book(name,press,img,author,price,sell);
			book.setCategory(category);
			this.bookServiceImpl.Add(book);
			this.bookServiceImpl.getList(request);//从数据库更新session bookList
			return "BackGround/indext";
		}
	}
	
	/*删除图书*/
	@RequestMapping("/deletebook")
	public String deleteBook(@RequestParam("i") int i,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Book> bookList = (List<Book>)session.getAttribute("bookList");
		this.bookServiceImpl.delete(bookList.get(i));
		this.bookServiceImpl.getList(request);//从数据库更新session bookList
		return "BackGround/indext";
	}
	
	/*跳转到修改图书页面前的处理*/
	@RequestMapping("/changepage")
	public String ChangePage(@RequestParam("i") int i,
			HttpSession session) {
		List<Book> bookList = (List<Book>)session.getAttribute("bookList");
		this.categoryServiceImpl.getList(session);
		session.setAttribute("book", bookList.get(i));
		return "BackGround/changeBook";
	}
	
	/*修改图书*/
	@RequestMapping("/changebook")
	public String changeBook(@RequestParam("Id") int id,@RequestParam("Category") int cid,
			@RequestParam("Name") String name,@RequestParam(value = "Img", required = false) String img,
			@RequestParam("Press") String press,@RequestParam("Author") String author,
			@RequestParam("Press") int price,@RequestParam(value = "Sell", required = false) Boolean sell,
			@RequestParam("button") String button,HttpServletRequest request) {
		if(button.equals("Back")) 
			return "BackGround/indext";
		else {
			Category category = this.categoryDaoImpl.getById(cid);
			Book book = new Book(name,press,img,author,price,sell);
			book.setCategory(category);
			this.bookServiceImpl.change(book);
			this.bookServiceImpl.getList(request);//从数据库更新session bookList
			return "BackGround/indext";
		}
	}
	
	/*图书详情*/
	@RequestMapping("/xiangqing")
	public String xiangQing(
			@RequestParam("book") int bookId,
			HttpSession session){
		session.setAttribute("book", this.bookServiceImpl.getById(bookId));
		return "Shop/xqPage";
	}
	
	/*将某本图书 添加到cart中*/
	@RequestMapping("/addCart")
	public String addCart(
			@RequestParam("book") int bookId,
			@RequestParam("ServletPath")String ServletPath,
			HttpSession session,HttpServletRequest request) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(userInfo==null) {
			request.setAttribute("errorinfo","请先登录");
			return "Login/login";
		}else {
			if(session.getAttribute("ItemList")!=null)
				session.removeAttribute("ItemList");
			this.bookServiceImpl.BookToCart(bookId,userInfo);//将Book存入userInfo  Cart 中
			
			return ServletPath.substring(1, ServletPath.length()-4);//跳转回请求的页面 
		}
	}
	/*生成显示的Cart*/
	@RequestMapping("/showcart")
	public String showCart(HttpSession session) {
		System.out.println("there is book controller /showcart");
		List<OrdersItem> ItemList = new ArrayList<OrdersItem>();
		if(((UserInfo)session.getAttribute("userInfo")).getCart()!=null) {
			ItemList.add(new OrdersItem(((UserInfo)session.getAttribute("userInfo")).getCart().get(0),0));
			for(Book book : ((UserInfo)session.getAttribute("userInfo")).getCart()) {
				int i = 0;
				for(OrdersItem item : ItemList) {
					if(item.getBook().getId()==book.getId()) {
						item.setNumber(item.getNumber()+1);
						i++;
						break;
					}
				}
				if(i==0) 
					ItemList.add(new OrdersItem(book,1));
			}
			session.setAttribute("ItemList", ItemList);
		}
		return "Shop/Cart";
	}
	
}
