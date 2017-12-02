package com.fairy.bookonline.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fairy.bookonline.entity.UserLogin;
import com.fairy.bookonline.user.service.UserLoginServiveImpl;

@Repository
@RequestMapping("user")
public class UserLoginController {
	@Resource
	private UserLoginServiveImpl userLoginServiveImpl;
	
	//◊¢≤·
	@RequestMapping("/register")
	public String Register(@RequestParam("loginName") String loginName,
			@RequestParam("password") String password,
			@RequestParam("password2") String password2,
			Model model, HttpSession session) {
		System.out.println("There is controller-register");
		UserLogin user = new UserLogin(loginName,password);
		
		//ºÏ≤‚◊¢≤·
		if(this.userLoginServiveImpl.CheckRegist(user,password2)) {
			//◊¢≤·
			this.userLoginServiveImpl.Register(user);
			user.setWord("");//∞—word÷√ø’
			session.setAttribute("user", user);//user ¥Ê»Îsession
			return "Login/login";//µ«»ÎΩÁ√Ê
		}else {
			session.setAttribute("user", user);//user ¥Ê»Îsession
			return "Login/register";//∑µªÿ◊¢≤·ΩÁ√Ê
		}
	}
	//µ«¬Ω
	@RequestMapping("/login")
	public String Login(@RequestParam("loginName") String loginName,
			@RequestParam("password") String password,
			@RequestParam("button") String button,
			Model model, HttpSession session) {
		System.out.println("There is controller-/login");
		System.out.println("name:"+loginName+" password: "+password+"  button: "+button);	
			if(button.equals("register")) {
				return "Login/register";
			}else {
				UserLogin user = new UserLogin(loginName,password);
				//ºÏ≤‚µ«¬Ω
				if(this.userLoginServiveImpl.Login(user)) {//ºÏ≤‚≥…π¶ ’À∫≈√‹¬Î’˝»∑
					session.setAttribute("user", user);//user ¥Ê»Îsession
					return "";
				}else {//ºÏ≤‚ ß∞‹ ’À∫≈√‹¬Î”–Œ Ã‚
					session.setAttribute("user", user);//user ¥Ê»Îsession
					return "Login/login";
				}
			}
	}
}
