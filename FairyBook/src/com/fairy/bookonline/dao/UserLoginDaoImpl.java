package com.fairy.bookonline.dao;

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
	
	/*save*/
	public void save(UserLogin user) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		session.save(user);
		tra.commit();
	}
	//获取LoginName对应的User（主键获取）
	/*getById(String)*/
	public UserLogin getByName(String loginName) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		UserLogin user = session.get(UserLogin.class,loginName);		
		tra.commit();
		return user;
	}
	//获取所有user（获取列表）
	/*getList*/
	public List<UserLogin> getList(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from UserLogin");
		return q.list();
	}
	//更新
	/*update*/
	public void update(UserLogin user) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		UserLogin user2 = session.get(UserLogin.class, user.getLoginname());
		user2 = user ;
		session.save(user);
		tra.commit();
	}
	//删除
	/*delete*/
	public void delete(UserLogin user) {
		
	}
	//通过名字删除
	/*deleteByName*/
	public void deleteByName(String userName) {
		
	}
}
