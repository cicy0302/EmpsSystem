package com.coderbar.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.coderbar.demo.bean.LoginUser;
import com.coderbar.demo.form.UserForm;

@Mapper
public interface UserMapper {
	// find　ⅮB参照
	public LoginUser find(String accountId);

	// ユーザー登録
	public List<String> insertUser(UserForm userForm);

	public LoginUser getUser(String accountId);

}