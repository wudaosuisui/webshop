package com.fairy.bookonline.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;

import org.springframework.stereotype.Repository;

import com.fairy.bookonline.entity.UserLogin;
import com.fairy.bookonline.user.dao.UserLoginDaoImpl;

@Repository
public class UserLoginServiveImpl {
	
	@Resource
	private UserLoginDaoImpl userLoginDao;
	
	//注册
	public void Register(UserLogin user) {
		this.userLoginDao.save(user);
	}
	//注册检测
	public Boolean CheckRegist(UserLogin user,String pwd2) {//检测欲注册的内容是否有问题
		//检测用户名 密码 密码2 是否为空
		if(!((user.getLoginname()==null)||(user.getPassword()==null)||(pwd2==null))) {

			//检测密码两次是否相同
			if(user.getPassword().equals(pwd2)) {
				//检测是否已有此注册名
				Query q = (Query) this.userLoginDao.getByName(user.getLoginname());
				if(q==null) 
					return true;//通过检测 可以注册
				else {
					user.setWord("此账号 已存在");//已经有此 注册名	
					return false;
				}
			}else {
				user.setWord("两次密码输入不一致");
				return false;
			}
		}else {
			user.setWord("账号、 密码 、再次输入的密码是必填项，不可为空");
			return false;
		}
		
	}
	//登陆
	public Boolean Login(UserLogin user) {
		UserLogin user1 = this.userLoginDao.getByName(user.getLoginname());
		if(user1==null) {
			user.setWord("查无此账号 ");
			return false;
		}else {
			if(user1.getPassword().equals(user.getPassword())){
				user.setWord("");
				return true;
			}
			user.setWord("账号与密码不匹配");
			return false;
		}
	}			
	
}
