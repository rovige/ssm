package com.lrf.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("userServcie")
public class UserService implements IntfService {
	public Object getUserInfo()
	{
		Map  m= new HashMap<>();
		m.put("name","lrf");
		m.put("age",30);
		return m;
	}
}
