package com.base.self.test;

import org.apache.commons.lang3.StringUtils;

public class FindsBugsTest {

	public static void main(String[] args) {
		String str = "123,123,123";
		String[] arr = str.split(",");  
		System.out.println(arr);
	}
	
	public void test() {
		String aString = "123";
		boolean b1 = aString.endsWith("12");
		boolean b2 = aString.equals("12");
	}
	
	public void test1(String id) {
		String sql = null;
//		if (id == null || id == "") {
		if (StringUtils.isNotEmpty(id)) {
			sql = "insert into xx values (1,?,?,?)";
		} else {
			sql = "insert into xx values ((select max(id) + 1 from xx),?,?,?)";
		}
		
	}
	
}
