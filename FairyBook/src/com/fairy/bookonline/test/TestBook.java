package com.fairy.bookonline.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("book")
public class TestBook {
	
	public static void main(String[] args) {
		System.out.println("main get");
		
		TestBook test = new TestBook();
		test.test();
	}
	@Resource
	private SessionFactory sessionFactory;
	
	@RequestMapping("/factory")
	public String test() {
		System.out.println("here is /factory");
		Session session = sessionFactory.openSession();
		System.out.println("here is /factory2");
		return "indext";
	}
}
