package com.coderbar.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coderbar.demo.bean.LoginUser;
import com.coderbar.demo.form.UserForm;
import com.coderbar.demo.mapper.UserMapper;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
	// 注入 userMapper
	@Resource
	private UserMapper userMapper;

	// private Locale locale=Locale.getDefault();
	@Override
	public List<String> insertUser(UserForm userForm) {
		return userMapper.insertUser(userForm);
	}

	@Override
	public LoginUser getUser(String accountId) {
		return userMapper.getUser(accountId);
	}

}