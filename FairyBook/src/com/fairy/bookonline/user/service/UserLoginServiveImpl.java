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
	
	//ע��
	public void Register(UserLogin user) {
		this.userLoginDao.save(user);
	}
	//ע����
	public Boolean CheckRegist(UserLogin user,String pwd2) {//�����ע��������Ƿ�������
		//����û��� ���� ����2 �Ƿ�Ϊ��
		if(!((user.getLoginname()==null)||(user.getPassword()==null)||(pwd2==null))) {

			//������������Ƿ���ͬ
			if(user.getPassword().equals(pwd2)) {
				//����Ƿ����д�ע����
				Query q = (Query) this.userLoginDao.getByName(user.getLoginname());
				if(q==null) 
					return true;//ͨ����� ����ע��
				else {
					user.setWord("���˺� �Ѵ���");//�Ѿ��д� ע����	
					return false;
				}
			}else {
				user.setWord("�����������벻һ��");
				return false;
			}
		}else {
			user.setWord("�˺š� ���� ���ٴ�����������Ǳ��������Ϊ��");
			return false;
		}
		
	}
	//��½
	public Boolean Login(UserLogin user) {
		UserLogin user1 = this.userLoginDao.getByName(user.getLoginname());
		if(user1==null) {
			user.setWord("���޴��˺� ");
			return false;
		}else {
			if(user1.getPassword().equals(user.getPassword())){
				user.setWord("");
				return true;
			}
			user.setWord("�˺������벻ƥ��");
			return false;
		}
	}			
	
}
