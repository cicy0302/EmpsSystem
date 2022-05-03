package com.coderbar.demo.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {
	private String accountId;
	private String password;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}