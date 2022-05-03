package com.coderbar.demo.controller;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderbar.demo.bean.EmpData;
import com.coderbar.demo.bean.Gender;
import com.coderbar.demo.bean.Nationality;
import com.coderbar.demo.form.EmpForm;
import com.coderbar.demo.service.EmpService;
import com.coderbar.demo.service.GenderService;
import com.coderbar.demo.service.NationalityService;

@Controller
public class AddController {

	@Resource
	private NationalityService nationalityService;
	@Resource
	private EmpService empService;
	@Resource
	private GenderService genderService;
	@Autowired
	private MessageSource messageSource;

	@GetMapping(value = "/toaddEmp")
	public String toAddEmp(@ModelAttribute("form") EmpForm form, Model model) {
		//Genderデータ取得,sessionに導入
		List<Nationality> nationalityList = nationalityService.getNationalityList();
		model.addAttribute("nationalityList", nationalityList);
		//Nationalityデータ取得,sessionに導入
		List<Gender> genderList = genderService.getGenderList();
		model.addAttribute("genderList", genderList);
		
		return ("addEmp");
	}

	@PostMapping("/addEmp")
	public String addEmp(@ModelAttribute("form") @Valid EmpForm empForm, BindingResult result, Model model,
			Locale locale) {
		String url;
		//errorがあるかどうか判断
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			model.addAttribute("errorList", errorList);

			List<Gender> genderList = genderService.getGenderList();
			model.addAttribute("genderList", genderList);
			List<Nationality> nationalityList = nationalityService.getNationalityList();
			model.addAttribute("nationalityList", nationalityList);

			return ("addEmp");
		} else {
			//errorがない
			EmpData empData = empService.getEmpData(empForm.getEmpCd());
			
			if (empData != null) {

				model.addAttribute("message", messageSource.getMessage("addEmp.error", null, locale));
				List<Gender> genderList = genderService.getGenderList();
				model.addAttribute("genderList", genderList);
				List<Nationality> nationalityList = nationalityService.getNationalityList();
				model.addAttribute("nationalityList", nationalityList);

				return ("addEmp");
			} else {
				 //正しい情報を登録
				empService.insertEmp(empForm);
				return ("redirect:/empList");
			}
		}
	}

}
