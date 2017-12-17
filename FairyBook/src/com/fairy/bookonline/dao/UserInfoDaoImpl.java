package com.fairy.bookonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairy.bookonline.entity.UserInfo;
import com.fairy.bookonline.entity.UserLogin;

@Repository
public class UserInfoDaoImpl {
	@Resource//注入sessionfectory
	private SessionFactory sessionFactory;
	
	/*save*/
	public void save(UserInfo userInfo) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		session.save(userInfo);
		session.flush();
		tra.commit();
	}
	
	//获取LoginName对应的User（主键获取）
	
	/*getByLoginName*/ 
	public UserInfo getByLoginName(String InfoName) {
		List<UserInfo> userInfoList = this.getList();
		UserInfo user = new UserInfo();
		for(UserInfo userInfo : userInfoList) {
			if(userInfo.getUserLogin().getLoginname().equals(InfoName)) 
				user = userInfo;
		}
		return user;
	}
	
	/*getById （主键获取）*/
	public UserInfo getById(int id) {	
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		UserInfo userInfo = session.get(UserInfo.class,id);		
		tra.commit();
		return null;
	}
	
	/*getList*/
	public List<UserInfo> getList(){
		Query q = this.sessionFactory.getCurrentSession()
				.createQuery("from UserInfo");
		return q.list();
	}
	
	/*update*/
	public void update(UserInfo userInfo) {
		Session session = sessionFactory.getCurrentSession();//获取session
		Transaction tra = session.beginTransaction();//开启事务
		session.update(userInfo);
		session.flush();
	    tra.commit();
	}
}







