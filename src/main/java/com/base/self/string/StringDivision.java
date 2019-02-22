package com.base.self.string;

import java.util.StringTokenizer;

/**
 * @author libo String 分割
 */
public class StringDivision {

	public static void main(String[] args) {
		
		String orgStr1 = getTestString();
		Long long1 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			orgStr1.split(";");
		}
		System.out.println(System.currentTimeMillis() - long1);

		String orgStr2 = getTestString();
		Long long2 = System.currentTimeMillis();
		StringTokenizer st = new StringTokenizer(orgStr2, ";");
		for (int i = 0; i < 1000; i++) {
			while (st.hasMoreElements()) {
				st.nextElement();
			}
			st = new StringTokenizer(orgStr2, ";");
		}
		System.out.println(System.currentTimeMillis() - long2);

		String orgStr3 = getTestString();
		Long long3 = System.currentTimeMillis();
		String tmp = orgStr3;
		for (int i = 0; i < 1000; i++) {
			while (true) {
				String splitStr = null;
				int j = tmp.indexOf(";");
				if (j < 0) {
					break;
				}
				splitStr = tmp.substring(0, j);
				tmp = tmp.substring(j + 1);
			}
			tmp = orgStr3;
		}
		System.out.println(System.currentTimeMillis() - long3);
	}

	static String getTestString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 1000; i++) {
			sb.append(i);
			sb.append(";");
		}
		return sb.toString();
	}

}
