package com.fairy.bookonline.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairy.bookonline.entity.UserLogin;


@Repository
public class UserLoginDaoImpl {
	
	@Resource//注入sessionfectory
	private SessionFactory sessionFactory;
	
	//save
	public void save(UserLogin user) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		
		session.save(user);
		tra.commit();
	}
	//获取LoginName对应的User（主键获取）
	public UserLogin getByName(String loginName) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		UserLogin user = session.get(UserLogin.class,loginName);		
		tra.commit();
		return user;
	}
	//获取所有user（获取列表）
	public List<UserLogin> getList(){
		Query q = this.sessionFactory.getCurrentSession()
				.createQuery("from UserLogin");
		return q.list();
	}
	//更新
	public void update(UserLogin user) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		UserLogin user2 = session.get(UserLogin.class, user.getLoginname());
		user2 = user ;
		session.save(user);
		tra.commit();
	}
	//删除
	public void delete(UserLogin user) {
		
	}
	//通过名字删除
	public void deleteByName(String userName) {
		
	}
	//
	//--------------测试代码
//	public void list(List<UserInfo> list,String name) {
//		for(UserInfo li:list) {
//			if(li.getLoginname().equals(name)) {
//				
//			}
//				
//		}
//		
//	}
//	Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake");
//	return q.list();
}
