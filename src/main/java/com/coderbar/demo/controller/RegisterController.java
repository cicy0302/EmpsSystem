package com.coderbar.demo.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderbar.demo.bean.LoginUser;
import com.coderbar.demo.form.UserForm;
import com.coderbar.demo.service.RegisterService;

@Controller
@ComponentScan({ "service" })
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	@Autowired
	public MessageSource messageSource;

	@GetMapping("/register")

	public String login(@ModelAttribute("form") UserForm userform, Model model) {
		return "register";
	}

	@PostMapping("/toempLogin")
	public String resgiter(@ModelAttribute("form") UserForm userform, BindingResult relust, Model model,
			Locale locale) {
		String url = null;
		if (relust.hasErrors()) {
			// ObjectError 错误信息
			List<ObjectError> errorList = relust.getAllErrors();
			model.addAttribute("errorList", errorList);
			url = "register";
			return url;
		}
		LoginUser loginUser = registerService.getUser(userform.getAccountId());
		if (loginUser != null) {

			model.addAttribute("message", messageSource.getMessage("addEmp.error", null, locale));
			url = "addEmp";
		} else {
			// 正しい情報を登録
			registerService.insertUser(userform);
			url = "redirect:/empList";
		}
		return url;
	}
}
