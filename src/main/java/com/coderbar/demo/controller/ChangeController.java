package com.coderbar.demo.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderbar.demo.bean.EmpData;
import com.coderbar.demo.bean.Gender;
import com.coderbar.demo.bean.Nationality;
import com.coderbar.demo.form.EmpForm;
import com.coderbar.demo.service.EmpService;
import com.coderbar.demo.service.GenderService;
import com.coderbar.demo.service.NationalityService;

@Controller
public class ChangeController {
	@Autowired
	private EmpService empService;
	@Autowired
	private GenderService genderService;
	@Autowired
	private NationalityService nationalityService;
	@Autowired
	HttpSession session;
	@Autowired
	public MessageSource messageSource;

	@PostMapping("/toChange")
	public String toChange(@RequestParam(value = "empCd") String empCd, @ModelAttribute("form") EmpForm empForm,
			Model model) {
		EmpData empData = empService.getEmpData(empCd);
		empForm.setEmpCd(empData.getEmpCd());
		empForm.setName(empData.getName());
		empForm.setGenderCd(empData.getGender().getGenderCd());
		empForm.setBirthday(empData.getBirthday().toString());
		empForm.setNationalityCd(empData.getNationality().getNationalityCd());
		
		// Genderデータ取得
		List<Gender> genderList = genderService.getGenderList();
		// Genderデータsessionに導入
		session.setAttribute("genderList", genderList);

		// Nationalityデータ取得
		List<Nationality> nationalityList = nationalityService.getNationalityList();
		// Nationalityデータsessionに導入
		session.setAttribute("nationalityList", nationalityList);
		
		return "empChange";
	}

	@PostMapping("/empChange")
	public String changeEmp(@RequestParam(value = "empCd") String empCd, @ModelAttribute("form") @Valid EmpForm empForm,
			BindingResult result, Model model, Locale locale) {
		String url;

		// errorがあるかどうか判断
		if (result.hasErrors()) {
			// error
			List<ObjectError> errorList = result.getAllErrors();
			// errorデータ画面に導入
			model.addAttribute("errorList", errorList);
			url = "empChange";
		} else {
			// 正しい情報を登録
			empService.changeEmp(empForm);
			url = "redirect:/empList";
		}		
		return url;
	}
}
