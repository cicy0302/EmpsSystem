package com.coderbar.demo.service;

import java.util.List;

import com.coderbar.demo.bean.EmpData;
import com.coderbar.demo.form.EmpForm;

public interface EmpService {

	public List<EmpData> listEmp();

	public List<EmpData> searchEmp(String keyWord);
	
	public EmpData getEmpData (String empCd);
	
    public void insertEmp(EmpForm empForm);
    
    public void changeEmp(EmpForm empForm);
    
    public void deleteEmp(String empCd);
}