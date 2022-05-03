package com.coderbar.demo.service;

import java.util.List;

import com.coderbar.demo.bean.LoginUser;
import com.coderbar.demo.form.UserForm;

public interface RegisterService {
    public List<String>insertUser(UserForm userForm);
  
	public LoginUser getUser(String accountId);
}