package com.base.self.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EqualsTest {

	public static void main(String[] args) {
		
//		String aString = null;
//		
//		if (!"1".equals(aString)) {
//			System.out.println("aString 不等于 1");
//		}
//		
//		if (aString.equals("1")) {
//
//		}
		
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = format.format(calendar.getTime());
			System.out.println(date);
	}

}
