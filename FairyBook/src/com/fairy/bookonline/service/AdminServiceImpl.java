package com.fairy.bookonline.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairy.bookonline.dao.AdminDaoImpl;
import com.fairy.bookonline.entity.Admin;

@Service
@Repository
public class AdminServiceImpl {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private AdminDaoImpl adminDaoImpl;
	
	/*Login*/
	public Boolean login(Admin admin , HttpServletRequest request) {
		Session session = sessionFactory.openSession();
		Admin adm = this.adminDaoImpl.getByName(admin.getLoginName());
		if(adm == null) {
			request.setAttribute("errorinfo", "≤ÈŒﬁ¥À’À∫≈");
			session.close();
			return false;
		}else {
			if(admin.getLoginName().equals(adm.getLoginName())) {
				HttpSession sessionh = request.getSession();
				sessionh.setAttribute("admin", admin);
				session.close();
				return true;
			}else {
				request.setAttribute("errorinfo", "’À∫≈√‹¬Î≤ª∆•≈‰");
				session.close();
				return false;
			}
		}
	}
	
}
