package com.coderbar.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.coderbar.demo.bean.Gender;

@Mapper
public interface GenderMapper {
	public List<Gender>getGenderList();
   
}
