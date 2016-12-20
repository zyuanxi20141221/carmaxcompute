package com.goopai.carmaxcompute.action;

import com.goopai.carmaxcompute.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction2 extends ActionSupport {

	private User user;

	public String add() {

		System.out.println("name:" + user.getName());
		System.out.println("age:" + user.getAge());
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
