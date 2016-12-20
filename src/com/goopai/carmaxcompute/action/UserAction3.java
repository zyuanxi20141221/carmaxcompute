package com.goopai.carmaxcompute.action;

import java.io.UnsupportedEncodingException;

import com.goopai.carmaxcompute.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction3 extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	public String add(){
		
		try {
			System.out.println("name:" + new String(user.getName().getBytes("iso-8859-1"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("age:" + user.getAge());
		return SUCCESS;
	}

	@Override
	public User getModel() {
		return user;
	}
}
