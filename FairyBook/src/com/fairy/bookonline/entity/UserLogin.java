package com.fairy.bookonline.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class UserLogin {
	

	private String loginname;
	private String password;
	
	public UserLogin() {}
	
	
	public UserLogin(String username, String password) {//User user,
		this.loginname = username;
		this.password = password;
	}

	@Id
    @GeneratedValue(generator="id")
    @GenericGenerator(name="id", strategy="assigned")
	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String username) {
		this.loginname = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
