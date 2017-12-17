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
	
	@Resource//ע��sessionfectory
	private SessionFactory sessionFactory;
	
	/*save*/
	public void save(UserLogin user) {
		Session session = sessionFactory.getCurrentSession();//��ȡsession
		Transaction tra = session.beginTransaction();//��������
		session.save(user);
		tra.commit();
	}
	//��ȡLoginName��Ӧ��User��������ȡ��
	/*getById(String)*/
	public UserLogin getByName(String loginName) {
		Session session = sessionFactory.getCurrentSession();//��ȡsession
		Transaction tra = session.beginTransaction();//��������
		UserLogin user = session.get(UserLogin.class,loginName);		
		tra.commit();
		return user;
	}
	//��ȡ����user����ȡ�б�
	/*getList*/
	public List<UserLogin> getList(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from UserLogin");
		return q.list();
	}
	//����
	/*update*/
	public void update(UserLogin user) {
		Session session = sessionFactory.getCurrentSession();//��ȡsession
		Transaction tra = session.beginTransaction();//��������
		UserLogin user2 = session.get(UserLogin.class, user.getLoginname());
		user2 = user ;
		session.save(user);
		tra.commit();
	}
	//ɾ��
	/*delete*/
	public void delete(UserLogin user) {
		
	}
	//ͨ������ɾ��
	/*deleteByName*/
	public void deleteByName(String userName) {
		
	}
}
