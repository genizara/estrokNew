package com.estrok.estrokApp;

import java.util.Calendar;
import java.util.TimeZone;

public class TestMain {
	public static void main(String[] args) {
		TimeZone seoul = TimeZone.getTimeZone("Asia/Seoul");
		Calendar calendar = Calendar.getInstance(seoul);
		
//		int yearArr[] = {2014, 2015, 2016, 2017, 2018, 2019, 2020};
		System.out.println("wet");
	    System.out.println(calendar.get(Calendar.YEAR));
	    System.out.println(calendar.get(Calendar.MONTH));
	}
}
