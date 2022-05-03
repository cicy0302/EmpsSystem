package com.coderbar.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coderbar.demo.bean.Gender;
import com.coderbar.demo.mapper.GenderMapper;

@Service
public class GenderServiceImpl implements GenderService{
	@Resource
	private GenderMapper GenderMapper;
	
	public List<Gender> getGenderList(){
		return GenderMapper.getGenderList();
	}
	
}