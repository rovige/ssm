package com.lrf.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lrf.service.IntfService;
import com.lrf.utils.SpringUtil;
/**
 * Contorller公用类
 * @author lrf
 *
 */
public class BaseController {
	/**
	 * 获取请求参数
	 * @param request
	 * @return
	 */
	public  Map getRequestParaMap(HttpServletRequest request) {
		Enumeration<String> enumStr = request.getParameterNames();
		Map paraMap = new HashMap<>();
			while (enumStr.hasMoreElements()) {
				String s = enumStr.nextElement();
				String[] values = request.getParameterValues(s);
				String 		value = new String(values[0].getBytes());
				paraMap.put(s, value);
			}
		return paraMap;
	}
	/**
	 * 成功返回JSON组装
	 * @param data
	 * @return
	 */
	public Map getSucessJSONData(Object data) {
		Map retData = new HashMap<>();
		retData.put("reponse_code", 1);
		retData.put("reponse_msg", "sucessfull");
		retData.put("data", data);
		return retData;
	}
	/**
	 * 失败返回JSON组装
	 * @param data
	 * @return
	 */
	public Map getFailureJSONData(String code,String msg,Object data) {
		Map retData = new HashMap<>();
		retData.put("reponse_code",code);
		retData.put("reponse_msg", msg);
		retData.put("data", data);
		return retData;
	}
}
