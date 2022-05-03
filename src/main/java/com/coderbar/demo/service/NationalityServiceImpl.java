package com.coderbar.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coderbar.demo.bean.Nationality;
import com.coderbar.demo.mapper.NationalityMapper;

@Service
public class NationalityServiceImpl implements NationalityService{
	@Resource
	private NationalityMapper NationalityMapper;
	
	public List<Nationality>getNationalityList(){
		return NationalityMapper.getNationalityList();
	}
	
}
