package com.base.self.string;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringReplace {
	public static void main(String[] args) {
		System.err.println("1234567890".replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date investDate = new Date(Long.valueOf("1509367026000".toString()));
		String date = simpleDateFormat.format(investDate);
		System.out.println(date);
	}
}
