package com.lrf.controller;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class APIController {
	@RequestMapping(value = "/v1/*", consumes = "application/json,text/html;", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object index(HttpServletRequest request, HttpServletResponse response) {
		Map paraMap = getRequestParaMap(request);
		System.out.println(paraMap);
		return paraMap;
	}

	@RequestMapping(value = { "/v2/{busiCode}", "/v2/{busiCode}/*" }, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object v2(@PathVariable("busiCode") String busiCode,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println(busiCode);
		Map paraMap = getRequestParaMap(request);
		return getResponseData("1", "sucess", paraMap);
	}

	private Map getRequestParaMap(HttpServletRequest request) {
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

	private Map getResponseData(String retCode, String msg, Object data) {
		Map retData = new HashMap<>();
		retData.put("reponse_code", retCode);
		retData.put("reponse_msg", msg);
		retData.put("data", data);
		return retData;
	}

}
