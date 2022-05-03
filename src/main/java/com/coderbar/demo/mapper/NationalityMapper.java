package com.coderbar.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.coderbar.demo.bean.Nationality;

@Mapper
public interface NationalityMapper {
	public List<Nationality> getNationalityList();
   
}
