package com.fairy.bookonline.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairy.bookonline.dao.UserInfoDaoImpl;
import com.fairy.bookonline.dao.UserLoginDaoImpl;
import com.fairy.bookonline.entity.UserInfo;
import com.fairy.bookonline.entity.UserLogin;

@Service
//@Repository
//@Transactional(readOnly=true)
public class UserLoginServiveImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private UserLoginDaoImpl userLoginDaoImpl;
	@Resource
	private UserInfoDaoImpl userinfoDaoImpl;

	/*��½*/
	/*Login*/ 
	public Boolean Login(UserLogin user,HttpServletRequest request) {
		Session session = sessionFactory.openSession();
		//��ȡ���ݿ����û�
		UserLogin user1 = this.userLoginDaoImpl.getByName(user.getLoginname());
		System.out.println("user get success");
		System.out.println("user login name :"+user1.getLoginname());
		if(user1==null) {
			request.setAttribute("errorinfo", "���޴��˺�");
			session.close();
			return false;
		}else {
			if(user1.getPassword().equals(user.getPassword())){
				HttpSession sessionh = request.getSession();
				sessionh.setAttribute("userInfo", this.userinfoDaoImpl.getByLoginName(user.getLoginname()));
				session.close();
				return true;
			}else {
			request.setAttribute("errorinfo", "�˺������벻ƥ��");
			session.close();
			return false;
			}
		}
	}			
	
//	//ע����
//	public Boolean CheckRegist(UserLogin user,String pwd2) {//�����ע��������Ƿ�������
//		//����û��� ���� ����2 �Ƿ�Ϊ��
//		if(!((user.getLoginname()==null)||(user.getPassword()==null)||(pwd2==null))) {
//
//			//������������Ƿ���ͬ
//			if(user.getPassword().equals(pwd2)) {
//				//����Ƿ����д�ע����
//				Query q = (Query) this.userLoginDao.getByName(user.getLoginname());
//				if(q==null) 
//					return true;//ͨ����� ����ע��
//				else {
//					user.setWord("���˺� �Ѵ���");//�Ѿ��д� ע����	
//					return false;
//				}
//			}else {
//				user.setWord("�����������벻һ��");
//				return false;
//			}
//		}else {
//			user.setWord("�˺š� ���� ���ٴ�����������Ǳ��������Ϊ��");
//			return false;
//		}
//		
//	}

}
