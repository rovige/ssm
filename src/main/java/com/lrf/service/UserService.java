package com.lrf.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
/**
 * 用户服务类
 * @author lrf
 *
 */
@Service("userService")
public class UserService implements IntfService {
	@Override
	public Object handle(Map paraMap) {
		// TODO Auto-generated method stub
		System.out.println(paraMap);
		return getUserInfo();
	}
	public Object getUserInfo()
	{
		Map  m= new HashMap<>();
		m.put("name","lrf");
		m.put("age",30);
		return m;
	}

	
}
