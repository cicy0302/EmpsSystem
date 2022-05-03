package com.coderbar.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.coderbar.demo.bean.EmpData;
import com.coderbar.demo.form.EmpForm;

@Mapper
public interface EmpMapper {
//	public void changeEmp(EmpForm emp);
//
//	public EmpData showEmpDetails(String empCd);
//
//	public void deleteEmp(String empCd);
//
//	public void addEmp(EmpData emp);
//
//	public void addEmp(EmpForm emp);
//
//	public List<EmpData> selectEmp(String kensaku);

	public List<EmpData> listEmp();

	public List<EmpData> searchEmp(String keyWord);

	public EmpData getEmpData(String empCd);

	public void insertEmp(EmpForm empForm);

	public void changeEmp(EmpForm empForm);

	public void deleteEmp(String empCd);
}
