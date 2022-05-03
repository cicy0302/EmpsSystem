package com.coderbar.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class EmpForm {
//	private String empCd;
//	private String name;
//	private Date birthday;
//	private Nationality nationality;
//	private Gender gender;
	
	@NotEmpty(message="{empCode.notEmpty}")
	@Pattern(regexp = "^[0-9]*$",message="{empCd.size}")
	@Size(min=5,max=5,message="{empCd.size}")
	private String empCd;
	
	@NotEmpty(message="{empName.notEmpty}")
	@Pattern(regexp="^[一-龥 ア-ン あ-ん a-z A-Z]*$",message="{empName.error}")
	private String name;
	
	@NotEmpty(message="{empBirthday.notEmpty}")
	private String birthday;
	
	@NotEmpty(message="{nationality.notEmpty}")
	private String nationalityCd;
    
	@NotEmpty(message="{empGender.notEmpty}")
	private String genderCd;
}

