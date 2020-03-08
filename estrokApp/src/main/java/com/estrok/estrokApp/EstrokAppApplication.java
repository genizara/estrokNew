package com.estrok.estrokApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.estrok.estrokApp.service.DataCollector;
import com.estrok.estrokApp.service.InsertStockCode;

@SpringBootApplication
public class EstrokAppApplication {

	public static void main(String[] args) {
		System.out.println("estrokAppapplication");
		SpringApplication.run(EstrokAppApplication.class, args);
		
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
