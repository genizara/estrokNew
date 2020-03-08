package com.estrok.estrokWeb.mapper;


import java.util.List;
import java.util.Map;

public interface MainMapper {
	public String select1();

	public Map<String, Object> findStock(Map<String, Object> params) throws Exception;
	
	public List<Map<String, Object>> getStockData(Map<String, Object> params) throws Exception;

	public List<Map<String, Object>> getEachStockData(Map<String, Object> params) throws Exception;

	public List<Map<String, Object>> getStockCodeList() throws Exception;
}
