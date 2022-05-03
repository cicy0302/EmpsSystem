package com.coderbar.demo.service;

import java.util.ArrayList;
import java.util.Locale;

import com.coderbar.demo.form.UserForm;

public interface UserService {
	public ArrayList<String> getResult(UserForm userForm,Locale locale);
}
