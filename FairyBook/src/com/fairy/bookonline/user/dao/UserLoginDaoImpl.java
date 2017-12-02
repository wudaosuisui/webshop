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
	
	@Resource//ע��sessionfectory
	private SessionFactory sessionFactory;
	
	//save
	public void save(UserLogin user) {
		Session session = sessionFactory.getCurrentSession();//��ȡsession
		Transaction tra = session.beginTransaction();//��������
		
		session.save(user);
		tra.commit();
	}
	//��ȡLoginName��Ӧ��User��������ȡ��
	public UserLogin getByName(String loginName) {
		Session session = sessionFactory.getCurrentSession();//��ȡsession
		Transaction tra = session.beginTransaction();//��������
		UserLogin user = session.get(UserLogin.class,loginName);		
		tra.commit();
		return user;
	}
	//��ȡ����user����ȡ�б�
	public List<UserLogin> getList(){
		Query q = this.sessionFactory.getCurrentSession()
				.createQuery("from UserLogin");
		return q.list();
	}
	//����
	public void update(UserLogin user) {
		Session session = sessionFactory.getCurrentSession();//��ȡsession
		Transaction tra = session.beginTransaction();//��������
		UserLogin user2 = session.get(UserLogin.class, user.getLoginname());
		user2 = user ;
		session.save(user);
		tra.commit();
	}
	//ɾ��
	public void delete(UserLogin user) {
		
	}
	//ͨ������ɾ��
	public void deleteByName(String userName) {
		
	}
	//
	//--------------���Դ���
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
