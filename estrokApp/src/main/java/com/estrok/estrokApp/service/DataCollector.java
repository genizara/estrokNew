package com.estrok.estrokApp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estrok.estrokApp.mapper.MainMapper;

@Service
public class DataCollector {

	@Autowired
	MainMapper mapper;
	
//	@PostConstruct
	public void getHistoricData() throws Exception{
//		String targetURL = "http://vip.mk.co.kr/newSt/rate/kospikosdaq_2.php?stCode=KPS001&sty=2019&stm=1&std=2&eny=2020&enm=1&end=10&x=26&y=10";
		System.out.println("------------start get data --------------");
		System.out.println(mapper.select1());
		
		int yearArr[] = {2014, 2015, 2016, 2017, 2018, 2019, 2020};
		
		
		int fromMonth = 1;
		int toMonth = 12;
		
		int fromDate = 1;
		int toDate = 31;
		
		try {
			
			for( int targetYear : yearArr ) {

				Document doc = Jsoup.connect("http://vip.mk.co.kr/newSt/rate/kospikosdaq_2.php?stCode=KPS001&sty="+targetYear+"&stm="+fromMonth+"&std="+fromDate+"&eny="+targetYear+"&enm="+toMonth+"&end="+toDate).get();
				
				Elements elements = doc.select(".table_5").eq(1).select("tr");
//				int size = elements.size();
//				System.out.println(elements.toString());
				
				int count = 0;
				int totalCnt = 0;
				List<Map<String, Object>>  paramList = new ArrayList<Map<String, Object>>();
				for (Element trs : elements) {
					count ++;
					totalCnt ++;
					if(count ==1) {
						continue;
					}
					HashMap<String, Object> params = new HashMap<String, Object>();
					String rawDate 		= trs.select("td").get(0).text(); // 날짜
					String rawClose 	= trs.select("td").get(1).text(); // 종가
					String rawStart		= trs.select("td").get(4).text(); // 시가
					String rawHigh		= trs.select("td").get(5).text(); // 고가
					String rawLow 		= trs.select("td").get(6).text(); // 저가 
					String rawAmount 	= trs.select("td").get(7).text(); // 거래량 
					String yyyymmdd= "20" + rawDate.substring(0,2) + rawDate.substring(3,5) + rawDate.substring(6,8);
					params.put("date", yyyymmdd);
					params.put("close", Double.parseDouble(rawClose.replaceAll(",", "")));
					params.put("start", Double.parseDouble(rawStart.replaceAll(",", "")));
					params.put("high", Double.parseDouble(rawHigh.replaceAll(",", "")));
					params.put("low", Double.parseDouble(rawLow.replaceAll(",", "")));
					params.put("amount", Double.parseDouble(rawAmount.replaceAll(",", "")));
					
					paramList.add(params);
					if(count == 50) {
						count = 0;
						mapper.insertHistoricData(paramList);
						
						paramList.clear();
						System.out.println("count : "  + totalCnt + " done....");
					}
				}
				if( paramList!=null && paramList.size() > 0 ) {
					
					mapper.insertHistoricData(paramList);
					System.out.println("count : "  + totalCnt + " done....");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.exit(0);
		
	}
	
}
