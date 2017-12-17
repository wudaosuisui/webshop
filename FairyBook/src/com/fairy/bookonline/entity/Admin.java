package com.fairy.bookonline.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	private String loginName;
	private String passWord;
	
	public Admin() {}
	public Admin(String loginName,String passWord) {
		this.loginName = loginName;
		this.passWord = passWord;
	}
	
	@Id
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
