package com.fairy.bookonline.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fairy.bookonline.entity.Admin;
import com.fairy.bookonline.entity.Page;
import com.fairy.bookonline.service.AdminServiceImpl;
import com.fairy.bookonline.service.BookServiceImpl;

@Controller
@Repository
@RequestMapping("admin")
public class AdminController {
	
	@Resource
	private AdminServiceImpl adminServiceImpl;
	@Resource
	private BookServiceImpl bookServiceImpl;
	
	/*Login*/
	@RequestMapping("/login")
	public String Login(@RequestParam("loginName") String loginName,
			@RequestParam("password") String password,
			HttpServletRequest request,HttpSession session) {
		Admin admin = new Admin(loginName,password);
		if(this.adminServiceImpl.login(admin, request)) {//登陆成功 admin 已经存入session（http）
			Page page1 = new Page(1,12);
			session.setAttribute("page", page1);
			this.bookServiceImpl.getList(request);//book 存入session（http）
			return "BackGround/indext";
		}else {
			//登陆失败
			return "BackGround/login";
		}
	}
	/*Logout*/
	@RequestMapping("/logout")
	public String LogOut(HttpSession session) {
		session.removeAttribute("admin");
		return "BackGround/login";
	}
}
