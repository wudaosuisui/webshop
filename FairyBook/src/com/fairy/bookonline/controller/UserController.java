package com.fairy.bookonline.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fairy.bookonline.dao.UserInfoDaoImpl;
import com.fairy.bookonline.entity.UserInfo;
import com.fairy.bookonline.entity.UserLogin;
import com.fairy.bookonline.service.UserInfoServiceImpl;
import com.fairy.bookonline.service.UserLoginServiveImpl;

@Controller
@Repository
@RequestMapping("user")
public class UserController {
	@Resource
	private UserLoginServiveImpl userLoginServiveImpl;
	@Resource
	private UserInfoServiceImpl userInfoServiveImpl;

	/*◊¢≤·*/
	@RequestMapping("/register")
	public String Register(
			@RequestParam("loginName") String loginName,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("slogan") String slogan,
			Model model, HttpSession session,HttpServletRequest request) {
		System.out.println("there is /register controller");
		UserLogin userLogin =new UserLogin(loginName,password);
		UserInfo userInfo = new UserInfo(userLogin,name,slogan);
		System.out.println("there is /register controller------1");
		if(this.userInfoServiveImpl.Register(userInfo, request)) { 
			System.out.println("there is /register controller-----------2");
			return "Login/login";
		}else {
			System.out.println("there is /register controller-------3");
			return "Login/register";
		}
	}
	/*µ«¬Ω*/
	@RequestMapping("/login")
	public String Login(
			@RequestParam("loginName") String loginName,
			@RequestParam("password") String password,
			@RequestParam("button") String button,
			Model model, HttpSession session,HttpServletRequest request) {
		System.out.println("there is user login controller");
			if(button.equals(" register ")) {
				return "Login/register";
			}else if(button.equals("backGround")){
				return "BackGround/login";
			}else {
				UserLogin user = new UserLogin(loginName,password);
				//ºÏ≤‚µ«¬Ω
				System.out.println("this.userLoginServiveImpl.Login(user,request)  is :"+this.userLoginServiveImpl.Login(user,request));
				if(this.userLoginServiveImpl.Login(user,request)) //ºÏ≤‚≥…π¶ ’À∫≈√‹¬Î’˝»∑;userInfo “—æ≠¥Ê»Îsessionh
					return "Shop/shop";
				else //ºÏ≤‚ ß∞‹ ’À∫≈√‹¬Î”–Œ Ã‚
					return "Login/login";
				
			}
	}
	/*Õ∆≥ˆµ«¬Ω*/
	@RequestMapping("/logout")
	public String LogOut(
//			@RequestParam("userId") int userId,
			HttpSession session) {
		System.out.println("there is logout controller-------------- 1");
		this.userInfoServiveImpl.logOut(session);
		System.out.println("there is logout controller-------------- 2");
		return "Shop/shop";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
