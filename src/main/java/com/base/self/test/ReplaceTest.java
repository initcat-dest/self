package com.base.self.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTest {

	public static void main(String[] args) {
		String aString = "a a, bAB";
		Pattern p = Pattern.compile("[^A-Z]*,*\\s*|\t|\r|\n");
		Matcher m = p.matcher(aString);
		aString = m.replaceAll("");
		System.out.println(aString);
	}
}
