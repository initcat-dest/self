package com.base.self.io;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;

public class IoTest {

	public static void main(String[] args) {
		String fileName = "/Users/libo/Desktop/aa.txt";
		IoTest.readFile(fileName);
		// IoTest.test(fileName);
	}

	public static ArrayList<String> readFile(String filePathAndName) {
		BufferedReader reader = null;
		InputStreamReader read = null;
		StringBuilder fileContent = new StringBuilder();
		try {
			File f = new File(filePathAndName);
			if (f.isFile() && f.exists()) {
				read = new InputStreamReader(new FileInputStream(f));
				reader = new BufferedReader(read);
				String line;
				while ((line = reader.readLine()) != null) {
					fileContent.append(line);
				}
			} else {
				System.out.println("文件不正确");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容操作出错");
			e.printStackTrace();
		} finally {
			try {
				if (read != null) {
					read.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String[] split = fileContent.toString().split("InsurancePingAnTransaction request");

		ArrayList<String> uaStrList = new ArrayList<>();
		for (String string : split) {
			if (string.contains("ua")) {
				uaStrList.add(string);
			}
		}
		ArrayList<String> uaList = new ArrayList<>();
		for (String object : uaStrList) {
			int indexOf = object.indexOf("[");
			int indexOf2 = object.indexOf("]");
			String substring = object.substring(indexOf + 1, indexOf2);
			String ua = JSON.parseObject(JSON.parseObject(substring).getString("value")).getJSONObject("phead")
					.getString("ua");
			System.out.println(ua);
			uaList.add(ua);
		}
		return uaList;
	}

	public static void test(String fileName) {
		FileInputStream in = null;
		try {
			in = new FileInputStream(fileName);
			byte[] buff = new byte[2];
			int len;
			String tes = "";
			for (; (len = in.read(buff)) != -1;) {
				String str = new String(buff, 0, len, "GBK");
				tes += str;
			}
			System.out.println(tes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				assert in != null;
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
