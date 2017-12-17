package com.fairy.bookonline.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fairy.bookonline.entity.Category;
import com.fairy.bookonline.service.CategoryServiceImpl;

@Controller
@Repository
@RequestMapping("category")
public class CategoryController {
	@Resource
	private CategoryServiceImpl categoryServiceImpl;
	
	@RequestMapping("/addcategory")
	public String AddCategory(@RequestParam("categoryName") String name) {
		Category category = new Category();
		category.setName(name);	
		this.categoryServiceImpl.Add(category);
		System.out.println("add success");
		return "BackGround/indext";
	}
//	@RequestMapping("/get")
//	public String GetList(HttpSession session) {
//		this.categoryServiceImpl.getList(session);
////		HttpSession session = request.getSession();
////		session.setAttribute("list", list);
//		return "Test/AddBook";
//	}
	
//	@RequestMapping("/getById")
//	public String GetById(HttpServletRequest request) {
//		Category category = this.categoryServiceImpl.getById(1);
////		List<Category> list = this.categoryServiceImpl.getList();
//		HttpSession session = request.getSession();
//		session.setAttribute("category1", category);
//		return "Test/AddBook";
//	}
}
