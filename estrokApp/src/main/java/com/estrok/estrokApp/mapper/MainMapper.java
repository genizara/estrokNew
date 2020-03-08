package com.estrok.estrokApp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MainMapper {
	
	public String select1();

	public void insertStockCodes(Map<String, Object> params) throws Exception;

	public void insertHistoricData(List<Map<String, Object>> list) throws Exception;

	public List<String> getCodeList() throws Exception;

	public void insertEachHistoricData(List<Map<String, Object>> paramList) throws Exception;

	public List<String> getCodeList2() throws Exception;

}
