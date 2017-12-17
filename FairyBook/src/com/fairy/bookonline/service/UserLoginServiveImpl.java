package com.fairy.bookonline.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairy.bookonline.dao.UserInfoDaoImpl;
import com.fairy.bookonline.dao.UserLoginDaoImpl;
import com.fairy.bookonline.entity.UserInfo;
import com.fairy.bookonline.entity.UserLogin;

@Service
//@Repository
//@Transactional(readOnly=true)
public class UserLoginServiveImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private UserLoginDaoImpl userLoginDaoImpl;
	@Resource
	private UserInfoDaoImpl userinfoDaoImpl;

	/*登陆*/
	/*Login*/ 
	public Boolean Login(UserLogin user,HttpServletRequest request) {
		Session session = sessionFactory.openSession();
		//获取数据库中用户
		UserLogin user1 = this.userLoginDaoImpl.getByName(user.getLoginname());
		System.out.println("user get success");
		System.out.println("user login name :"+user1.getLoginname());
		if(user1==null) {
			request.setAttribute("errorinfo", "查无此账号");
			session.close();
			return false;
		}else {
			if(user1.getPassword().equals(user.getPassword())){
				HttpSession sessionh = request.getSession();
				sessionh.setAttribute("userInfo", this.userinfoDaoImpl.getByLoginName(user.getLoginname()));
				session.close();
				return true;
			}else {
			request.setAttribute("errorinfo", "账号与密码不匹配");
			session.close();
			return false;
			}
		}
	}			
	
//	//注册检测
//	public Boolean CheckRegist(UserLogin user,String pwd2) {//检测欲注册的内容是否有问题
//		//检测用户名 密码 密码2 是否为空
//		if(!((user.getLoginname()==null)||(user.getPassword()==null)||(pwd2==null))) {
//
//			//检测密码两次是否相同
//			if(user.getPassword().equals(pwd2)) {
//				//检测是否已有此注册名
//				Query q = (Query) this.userLoginDao.getByName(user.getLoginname());
//				if(q==null) 
//					return true;//通过检测 可以注册
//				else {
//					user.setWord("此账号 已存在");//已经有此 注册名	
//					return false;
//				}
//			}else {
//				user.setWord("两次密码输入不一致");
//				return false;
//			}
//		}else {
//			user.setWord("账号、 密码 、再次输入的密码是必填项，不可为空");
//			return false;
//		}
//		
//	}

}
