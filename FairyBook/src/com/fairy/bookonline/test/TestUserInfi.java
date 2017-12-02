package com.fairy.bookonline.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairy.bookonline.user.dao.UserLoginDaoImpl;

@Repository
//@RequestMapping("UserInfo")
public class TestUserInfi {
	
	@Resource
	private UserLoginDaoImpl dao;
	
}
