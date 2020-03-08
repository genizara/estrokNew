package com.estrok.estrokApp.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.estrok.estrokApp.EstrokAppApplication;
import com.estrok.estrokApp.mapper.MainMapper;

@Service
public class InsertStockCode {

	@Autowired
	MainMapper mapper;
	
//	public static void main(String[] args) {
//		SpringApplication.run(EstrokAppApplication.class, args);
//
//		try {
//			
//			new InsertStockCode().insertStockCode();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.exit(0);
//		
//	}
	
	public void insertStockCode() throws Exception {

		
		

		String stockCodesCsvPath = "C:/datas/estrok/";
		String stockCodesCsvFileName = "code_data.csv";

		FileReader fr = null;
		BufferedReader br = null;
		try {

			System.out.println("시작");


			fr = new FileReader(new File(stockCodesCsvPath + stockCodesCsvFileName));
			br = new BufferedReader(fr);
			Map<String, Object> params = new HashMap<String, Object>();
			String line = null;
			int lineNum = 0;
			while ((line = br.readLine()) != null) {
				lineNum++;
				if (lineNum == 1) {
					continue; // 첫줄 지나가기~
				}
//				System.out.println(lineNum + " : " + line);

//				String[] data = line.split("\\|");
				String[] data = line.split(",");
				if (data.length < 8) {
					continue;
				}
				System.out.println(lineNum + " / " + data[1] + " /  " + data[2] + " /  " + data[3]  );
//				System.out.println(data[0] + " /  " + data[1] + " /  " + data[2] + " /  " + data[3] + " /  " + data[4] + " /  " + data[5] + " /  " + data[6] + " /  " + data[7]);

				System.out.println("       ");
				
				params.put("stockCode", data[1]);
				params.put("stockName", data[2]);
				
				
				mapper.insertStockCodes(params);
				
//				if (lineNum % 100 == 0) {
//					System.out.println(">> " + lineNum);
//				}
			}
			System.out.println("TOTAL : " + (lineNum - 1));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
		System.out.println("----------------------------------------");
		System.exit(0);
	}
}
