package com.base.self.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.base.common.util.Base64;

public class MilesCommUtil {
	
	public static void main(String[] args) {
//		Map<String, Integer> codeMap = new HashMap<>();
//		for (int i = 1; i <= 10000000; i++) {
////			codeMap.put(generateRandomCode(8), 0);
//			codeMap.put(genRandomString(8), 0);
//			if (i % 20000 == 0) {
//				System.out.println("i = " + i + ", codeMapSize = " + codeMap.size());
//			}
//		}
		
		
		
//		int len = 8;
//		// 得到0.0到1.0之间的数字，并扩大100000倍
//		double temp = Math.random() * 100000;
//		// 如果数据等于100000，则减少1
//		if (temp >= 100000) {
//			temp = 99999;
//		}
//		int random = (int) Math.ceil(temp);
//		Random rd = new Random(random);
//		final int maxNum = 62;
//		StringBuffer sb = new StringBuffer();
//		int rdGet;// 取得随机数
//		char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
//				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
//				'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
//				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
//				'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//
//		int count = 0;
//		while (count < len) {
//			rdGet = Math.abs(rd.nextInt(maxNum));// 生成的数最大为62-1
//			if (rdGet >= 0 && rdGet < str.length) {
//				sb.append(str[rdGet]);
//				count++;
//			}
//		}
//		System.out.println(sb.toString());
		
		Random rdd = new Random(666);
		for (int j = 1; j <= 10; j++) {
			System.out.println(Math.abs(rdd.nextInt(62)));
//			System.out.println(Math.abs(rd.nextInt(62)));
//			Random rd1 = new Random();
//			System.out.println(Math.abs(rd1.nextInt(62)));

		}
		
		final int maxNum = 62;
		int count = 0;
		int rdGet = 0;
		int random = createRandomInt();
		System.out.println(random);
		Random rd = new Random(random);
		while (count < 8) {
			System.out.println("--:" + rd.nextInt(maxNum));
			rdGet = Math.abs(rd.nextInt(maxNum));// 生成的数最大为62-1
			if (rdGet >= 0 && rdGet < 62) {
				System.out.println(rdGet);
				count++;
			}
		}
	}
	
	/**
	 * 获得随机code
	 * @param len code长度
	 * @return
	 */
	public static String generateRandomCode(int len) {
		int random = createRandomInt();
		return generateRandomCode(random, len);
	}

	public static String generateRandomCode(int random, int len) {
		Random rd = new Random(random);
		final int maxNum = 62;
		StringBuffer sb = new StringBuffer();
		int rdGet;// 取得随机数
		char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
				'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
				'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

		int count = 0;
		while (count < len) {
			rdGet = Math.abs(rd.nextInt(maxNum));// 生成的数最大为62-1
			if (rdGet >= 0 && rdGet < str.length) {
				sb.append(str[rdGet]);
				count++;
			}
		}
		return sb.toString();
	}

	public static int createRandomInt() {
		// 得到0.0到1.0之间的数字，并扩大100000倍
		double temp = Math.random() * 100000;
		// 如果数据等于100000，则减少1
		if (temp >= 100000) {
			temp = 99999;
		}
		int tempint = (int) Math.ceil(temp);
		return tempint;
	}
	
	public static String genRandomString(int strLen) {
        Random random = new Random();
        byte[] bytes = new byte[strLen];
        random.nextBytes(bytes);

        try {
            return Base64.encodeBytes(bytes).substring(0, strLen);
        } catch (Exception var4) {
            return "";
        }
    }
}
