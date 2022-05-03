package com.coderbar.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderbar.demo.bean.EmpData;
import com.coderbar.demo.service.EmpServiceImpl;


@Controller
@ComponentScan({ "service" })
public class ListController {
	@Autowired
	private EmpServiceImpl empService;

	@GetMapping("/empList")
	public String listEmp(Model model) {
		List<EmpData> empList = empService.listEmp();
		session.setAttribute("empList", empList);
		model.addAttribute("empList", empList);
		return "empList";
	}

	@GetMapping("/searchEmp")
	public String searchEmp(@RequestParam(value = "keyWord") String keyWord, Model model) {
		List<EmpData> empList = empService.searchEmp(keyWord);
		session.setAttribute("empList", empList);
		model.addAttribute("empList", empList);
		return "empList";
	}

	@GetMapping("/showDetails")
	public String showDetails(@RequestParam(value = "empCd") String empCd, Model model) {
		EmpData empData = empService.getEmpData(empCd);
		model.addAttribute("empData", empData);
		return "empDetails";
	}
	@PostMapping("/delete")
	public String deleteEmp(@RequestParam(value = "empCd") String empCd, Model model) {
		empService.deleteEmp(empCd);
		return "redirect:/empList";

	}

	@Autowired
	HttpSession session;
	@GetMapping("/u_denpyouExcel")
	public void empListExcel(HttpServletResponse response) throws IOException {
		//一覧画面のリストを使う
		@SuppressWarnings("unchecked")
		List<EmpData> empData =  (List<EmpData>) session.getAttribute("empList");
		// excelを生成する
		empService.empListExcel(response, empData);
	} 
	
}