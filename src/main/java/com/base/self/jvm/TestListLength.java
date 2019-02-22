package com.base.self.jvm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestListLength {
	
	@Test
	public void test() throws InterruptedException {
		List<String> test01 = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			test01.add("test");
		}
		Long start01 = System.currentTimeMillis();
		for (int i = 0; i < test01.size(); i++) {
			
		}
		Thread.sleep(1000);
		System.out.println("time01=" + (System.currentTimeMillis() - start01));
		
		Long start02 = System.currentTimeMillis();
		int size = test01.size();
		for (int i = 0; i < size; i++) {
			
		}
		Thread.sleep(1000);
		System.out.println("time02=" + (System.currentTimeMillis() - start02));
	}
	
}
