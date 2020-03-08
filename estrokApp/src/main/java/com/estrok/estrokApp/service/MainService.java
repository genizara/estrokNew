package com.estrok.estrokApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estrok.estrokApp.mapper.MainMapper;

@Service
public class MainService {

	@Autowired
	MainMapper mapper;
	
	public String select1() {
		return mapper.select1();
	}

}
