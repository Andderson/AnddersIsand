package com.myapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.dao.UserMapper;
import com.myapp.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	public List<String> getWorldCityNames() {
		List<String> cityNames =	userMapper.getCities();
		return cityNames;
	}


}
