package com.fairy.bookonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class UserLogin {
	private String loginname;
	private String password;
	private String word;
	
	//构造
	public UserLogin() {}

	public UserLogin(String loginname, String password) {
//		super();
		this.loginname = loginname;
		this.password = password;
	}
	
	//set&get
	@Id
	@GeneratedValue(generator = "uid")
    @GenericGenerator(name="uid", strategy="assigned")//手动输入主键
	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
}
