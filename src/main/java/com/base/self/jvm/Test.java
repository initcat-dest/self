package com.base.self.jvm;

import java.util.Vector;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		test02();
	}
	
	public static void test02() {
		Vector v = new Vector();
		for(int i = 1; i<=10;i++) {
			byte[] bs = new byte[1024*1024];
			v.add(bs);
			if (v.size() == 3) {
				v.clear();
			}
		}
	}
	
	public static void test01() {
//		Thread.sleep(5000);
		{
			byte[] b = new byte[6 * 1024 * 1024];
			b = null;
		}
		System.gc();
		System.out.println("first explict gc over");
	}
	
	
}
