package com.coderbar.demo.service;

import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.coderbar.demo.bean.LoginUser;
import com.coderbar.demo.form.UserForm;
import com.coderbar.demo.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	
	@Autowired
	private MessageSource messageSource;
	
	public ArrayList<String> getResult(UserForm userForm,Locale locale) {
//      调用mapper
		LoginUser loginUser = userMapper.find(userForm.getAccountId());
		ArrayList<String> errorlist = new ArrayList<String>();
		if(loginUser == null) {
			errorlist.add(messageSource.getMessage("login.message.accountId.error", null, locale));
//			errorlist.add("Incorrect accountId");
		}else if(!loginUser.getPassword().equals(userForm.getPassword())) {
			errorlist.add(messageSource.getMessage("login.message.password.error", null, locale));
//			errorlist.add("Incorrect Password");
		}
		return errorlist;
	}
}
