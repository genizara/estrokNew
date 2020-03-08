package com.estrok.estrokWeb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.estrok.estrokWeb.service.MainService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class MainController {

	@Autowired
	MainService service;
	
	@RequestMapping(value="/main")
	public ModelAndView main(HttpServletRequest request, ModelAndView mv, @RequestParam Map<String, Object> params) throws Exception {
		System.out.println("start main!");

		Map<String, Object> resultMap = new HashMap<String, Object>();
		mv.addAllObjects(params);
		try {
			
			service.getStockCodeList(resultMap);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addAllObjects(resultMap);
		
		mv.setViewName("/main");
		System.out.println("finish main!");

		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/getStockJsonData")
	public String getStockJsonData(HttpServletRequest request, @RequestParam Map<String, Object> params, @RequestBody Map<String, Object> jsonParam) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			
			System.out.println(jsonParam);
			params.put("search_type", jsonParam.get("search_type").toString());
			params.put("search_value", jsonParam.get("search_value").toString());
			
			service.getStockJsonData(params, resultMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("finish getStockJsonData!");
		return new Gson().toJson(resultMap).toString();
	}
	
	
}
