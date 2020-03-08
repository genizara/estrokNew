package com.estrok.estrokApp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estrok.estrokApp.mapper.MainMapper;
import com.estrok.estrokApp.util.CmnUtil;

@Service
public class CalcEachStockRsService {
	
	MainMapper mapper;
	
	@Autowired
	public CalcEachStockRsService(MainMapper mapper) {
		this.mapper = mapper;
	}
	
//	@PostConstruct
	public void insertDailyEachStockHistoryData() throws Exception {

//		System.out.println("------------start DailyEachStockHistoryService data --------------");
//		System.out.println(mapper.select1());
//
//		TimeZone seoul = TimeZone.getTimeZone("Asia/Seoul");
//		Calendar calendar = Calendar.getInstance(seoul);
//		
//		int yearArr[] = {2014, 2015, 2016, 2017, 2018, 2019, 2020};
////		int yearArr[] = {calendar.get(Calendar.YEAR)};
////		int yearArr[] = {2020};
//			
////		int fromMonth = calendar.get(Calendar.MONTH) + 1;
////		int toMonth = calendar.get(Calendar.MONTH) + 1;
//		int fromMonth = 0 + 1;
//		int toMonth = 11 + 1;
//		
//		int fromDate = 1;
//		int toDate = 31;
//		
//		try {
//			int nowCodeCnt = 0;
//			List<String> stockCodeList = mapper.getCodeList2();
//	
//			for(String code : stockCodeList) {
//				nowCodeCnt ++;
//				System.out.println("code : " + code + " job has been started.");
//
//				for( int targetYear : yearArr ) {
//					
//						for(int page = 1; page < 8; page ++) {
////							String url = "http://vip.mk.co.kr/newSt/price/daily.php?";
//							String url1 = "http://vip.mk.co.kr/newSt/price/daily.php?p_page="+page+"&y1="+targetYear+"&m1="+CmnUtil.monthFormat(fromMonth)+"&d1="+CmnUtil.monthFormat(fromDate)+"&y2="+targetYear+"&m2="+CmnUtil.monthFormat(toMonth)+"&d2="+toDate+"&stCode="+code;
//				
//							Document doc = null;
//
//							for( int trycnt = 0 ; trycnt < 5 ; trycnt ++) {
//								try {
//									doc = Jsoup.connect(url1).get();
//								} catch (Exception e) {
//									System.out.println(e);
//									Thread.sleep(1000);
//									continue;
//								}
//								break;
//								
//							}
//							
//							Elements elements = doc.select(".table_3").eq(0).select("tr");
//							//				int size = elements.size();
//							//				System.out.println(elements.toString());
////							System.out.println(elements.html());
////							System.exit(0);
//							int count = 0;
//							int totalCnt = 0;
//							List<Map<String, Object>>  paramList = new ArrayList<Map<String, Object>>();
//							for (Element trs : elements) {
//								count ++;
//								totalCnt ++;
//								if(count ==1) {
//									continue;
//								}
//								HashMap<String, Object> params = new HashMap<String, Object>();
//								String rawDate 		= trs.select("td").get(0).text(); // 날짜
//								String rawClose 	= trs.select("td").get(1).text(); // 종가
//								String rawStart		= trs.select("td").get(4).text(); // 시가
//								String rawHigh		= trs.select("td").get(5).text(); // 고가
//								String rawLow 		= trs.select("td").get(6).text(); // 저가 
//								String rawAmount 	= trs.select("td").get(7).text(); // 거래량 
//								String yyyymmdd= "20" + rawDate.substring(0,2) + rawDate.substring(3,5) + rawDate.substring(6,8);
//								params.put("code", code);
//								params.put("date", yyyymmdd);
//								params.put("close", Double.parseDouble(rawClose.replaceAll(",", "")));
//								params.put("start", Double.parseDouble(rawStart.replaceAll(",", "")));
//								params.put("high", Double.parseDouble(rawHigh.replaceAll(",", "")));
//								params.put("low", Double.parseDouble(rawLow.replaceAll(",", "")));
//								params.put("amount", Double.parseDouble(rawAmount.replaceAll(",", "")));
//								
//								paramList.add(params);
//								if(count == 50) {
//									count = 0;
//									mapper.insertEachHistoricData(paramList);
//									
//									paramList.clear();
////									System.out.println("count : "  + totalCnt + " done....");
//								}
//							}
//							if( paramList!=null && paramList.size() > 0 ) {
//								
//								mapper.insertEachHistoricData(paramList);
////								System.out.println("\t\t count : "  + totalCnt + " done....");
//							}
//						}
//						System.out.println("\t\t year : " + targetYear + " is done.");
//						Thread.sleep(10);
//				}
//				System.out.println("-------------------code : " + code + " is done. [ " + nowCodeCnt + "/" + stockCodeList.size() + "]");
//				Thread.sleep(10);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		System.out.println("------------finish DailyEachStockHistoryService data --------------");
//		System.exit(0);
//		
	}

}

