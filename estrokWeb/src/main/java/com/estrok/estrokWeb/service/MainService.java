package com.estrok.estrokWeb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estrok.estrokWeb.mapper.MainMapper;
import com.google.gson.Gson;

@Service
public class MainService {

	@Autowired
	MainMapper mapper;
	
	public String select1() {
		return mapper.select1();
	}

	public void getStockData(Map<String, Object> params, Map<String, Object> resultMap) throws Exception{
		
		System.out.println(params.toString());
		Map<String, Object> result1 = mapper.findStock(params);
		boolean isEmptySearchResult = result1==null || result1.get("stock_code")==null;
		
		if( ! isEmptySearchResult ) {
			
			resultMap.put("result_code", result1.get("stock_code"));
			resultMap.put("result_name", result1.get("stock_name"));
			params.put("code", result1.get("stock_code"));
			List<Map<String, Object>> dataList = mapper.getEachStockData(params);
		
			resultMap.put("dataList", dataList);
		}
		
		
	}

	public void getStockJsonData(Map<String, Object> params, Map<String, Object> resultMap) throws Exception{
		
		Map<String, Object> result1 = mapper.findStock(params);
		boolean isEmptySearchResult = result1==null || result1.get("stock_code")==null;
		
		if( ! isEmptySearchResult ) {
			

			params.put("code", result1.get("stock_code"));
			List<Map<String, Object>> dataList = mapper.getEachStockData(params);
		
			resultMap.put("stockMeta", result1);
			resultMap.put("dataList", dataList);
		}
		
		
	}

	public void getStockCodeList(Map<String, Object> resultMap) throws Exception{
		List<Map<String, Object>> codeList = mapper.getStockCodeList();
		resultMap.put("codeList",  new Gson().toJson(codeList).toString());
	}

}
