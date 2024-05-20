package com.supermarket.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UniqueGenerator {
	
	public static String getUniqueString(String name) {
		return name.concat(getCurrentDateTime());
	}
	
	public static String getCurrentDateTime() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return timeStamp;
	}
	public  static String getRandomNumber() {
		int min = 1;  
		int max = 100000;  
		double a = Math.random()*(max-min+1)+min; 
		 return Double.toString(a);
	}
}
