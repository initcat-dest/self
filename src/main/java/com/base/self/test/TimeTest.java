package com.base.self.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeTest {
	public static void main(String[] args) throws ParseException {
//		String dt = "Monday May 21 2018 12:00:00 AM CST";
//
//		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss a z", Locale.ENGLISH);
		
		String dt = "Wednesday, June 20, 2018 12:00:00 AM CST";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, MMM dd, yyyy HH:mm:ss a z", Locale.ENGLISH);

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println(sdf2.format(sdf1.parse(dt)));
		
	
	}
}
