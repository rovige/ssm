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
 * API接口类
 * @author lrf
 *
 */
@Controller
@RequestMapping("/api")
public class APIController  extends BaseController{
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
		IntfService service = (IntfService)SpringUtil.getObject("userService");
		Map paraMap = getRequestParaMap(request);
		Object retData  = service.handle(paraMap);
		return getSucessJSONData(retData);
	}

}
