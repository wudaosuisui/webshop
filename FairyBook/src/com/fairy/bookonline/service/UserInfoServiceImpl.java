package com.fairy.bookonline.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairy.bookonline.dao.OrdersDaoImpl;
import com.fairy.bookonline.dao.UserInfoDaoImpl;
import com.fairy.bookonline.dao.UserLoginDaoImpl;
import com.fairy.bookonline.entity.Orders;
import com.fairy.bookonline.entity.UserInfo;
import com.fairy.bookonline.entity.UserLogin;

@Service
@Repository
public class UserInfoServiceImpl {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private UserInfoDaoImpl userInfoDaoImpl;
	@Resource
	private UserLoginDaoImpl userLoginDaoImpl;
	@Resource
	private OrdersDaoImpl ordersDaoImpl;
	
//	@Resource
//	private UserLoginServiveImpl userLoginServiveImpl;
	
	
//	//save
//	public Boolean save(UserInfo userInfo,String pwd2) {
//		//panduan
//		Boolean b = this.userLoginServiveImpl.CheckRegist(userInfo.getUserLogin(), pwd2) ;
//		if(b) {
//			this.userLoginServiveImpl.Register(userInfo.getUserLogin());
//			this.userInfoDaoImpl.save(userInfo);
//			return true;
//		}else {
//			return false;
//		}
//	}
	/*注册*/
	/*Register*/
	public Boolean Register(UserInfo userInfo,HttpServletRequest request ) {
		System.out.println("there is userServce ");
		Session session = sessionFactory.openSession();
		//检测是否已有此注册名
		UserLogin u = this.userLoginDaoImpl.getByName(userInfo.getUserLogin().getLoginname());
		System.out.println("there is userServce ------------1");
		if(u==null) {
			System.out.println("there is userServce ------------2");
			this.userLoginDaoImpl.save(userInfo.getUserLogin());//通过检测 可以注册
			this.userInfoDaoImpl.save(userInfo);		
			System.out.println("there is userServce ------------3");
			session.close();
			return true;
		}else {
			System.out.println("there is userServce ------------4");
			request.setAttribute("errorinfo", "用户名已存在，不可再次注册！");
			session.close();
			return false;
		}
	}
	/*退出登录*/
	public void logOut( HttpSession sessionh) {
		Session session = sessionFactory.openSession();
		System.out.println("there is logout service ");
//		UserInfo userInfo = this.userInfoDaoImpl.getById(userId);
		UserInfo userInfo = (UserInfo)sessionh.getAttribute("userInfo");
		System.out.println("there is logout service-------------- 1");

		//Cart   即  更新userInfo???
		this.userInfoDaoImpl.update(userInfo);
//		System.out.println("there is logout service-------------- 2");
//		//remou cart
		sessionh.removeAttribute("ItemList");
//		System.out.println("there is logout service-------------- 3");
		Object ord = sessionh.getAttribute("orders");
		if(ord!=null) {
			Orders orders = (Orders)ord;
			this.ordersDaoImpl.deleteById(orders.getId());
		}
//		//remou user
		sessionh.removeAttribute("userInfo");

		System.out.println("there is logout service-------------- 4");
		session.close();
	}
	
//	/*注册*/
//	/*Register*/
//	public Boolean Register(UserLogin user,HttpServletRequest request ) {
//		Session session = sessionFactory.openSession();
//		//检测是否已有此注册名
//		Query q = (Query) this.userLoginDao.getByName(user.getLoginname());
//		if(q==null) {
//			this.userLoginDao.save(user);//通过检测 可以注册
//			session.close();
//			return true;
//		}else {
//			request.setAttribute("errorinfo", "用户名已存在，不可再次注册！");
//			session.close();
//			return false;
//		}
//	}
	
}









