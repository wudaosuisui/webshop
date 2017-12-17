package com.fairy.bookonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.fairy.bookonline.entity.Admin;

@Repository
public class AdminDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	/*save*/ // ½ûÓÃ
	/*getByName*/
	public Admin getByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Admin a = session.get(Admin.class, name);
		return a;
	}
}













