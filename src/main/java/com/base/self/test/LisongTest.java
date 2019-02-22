package com.base.self.test;

import java.util.Scanner;

/**
 * names
 * ["A", "B", "C"]
 * 
 * prices
 * [5, 89, 2]
 * 
 * numbers
 * [100, 80, 290]
 * 
 * ---------------------
 * 
 * 1. 商品列表
 * 
 * 2. 商品录入
 * 
 * 3. 商品查询
 * 
 * 4. 统计信息
 * 
 * 5. 退出
 * 
 * ---------------------
 * 
 * 选择：1
 * 项目：day0404_商品录入查询
 * 类： day0404.Test1
 * @author libo
 */
public class LisongTest {

	// 商品名称数组
	static String[] names = { "iPhoneX", "华为P20", "小米8", "vivo NEX", "oppo Find X" };

	// 价格数组
	static double[] prices = { 6890, 4799, 2999, 3899, 3199 };

	// 商品数量数组
	static int[] numbers = { 80, 50, 100, 150, 90 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			outer:
			while (true) {
				// 显示菜单并获得选择的值
				int c = menu(scanner);
				switch (c) {
				case 1:
					f1();
					break;
				case 2:
					f2(scanner);
					break;
				case 3:
					f3();
					break;
				case 4:
					f4();
					break;

				case 5:
					break outer;
				default:
					System.out.println("选择错误");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

	private static int menu(Scanner scanner) {

		System.out.println("---------------------");

		System.out.println("1. 商品列表");

		System.out.println("2. 商品录入");

		System.out.println("3. 商品查询");

		System.out.println("4. 统计信息");

		System.out.println("5. 退出");

		System.out.println("---------------------");

		System.out.print("选择：");

		int c = scanner.nextInt();

		return c;
	}

	private static void f1() {

		/*
		 * 
		 * 1. 名称：xx，价格：xx，数量：xx
		 * 
		 * 2. ...
		 * 
		 */

		// 遍历数组

		for (int i = 0; i < names.length; i++) {

			System.out.println(

					(i + 1) + ". 名称：" + names[i] +

							"，价格：" + prices[i] +

							"，数量：" + numbers[i]);

		}

	}

	private static void f2(Scanner scanner) {

		// 遍历数组

		for (int i = 0; i < names.length; i++) {

			System.out.println("录入第" + (i + 1) + "件商品");

			System.out.print("名称：");

			String n = scanner.nextLine();

			System.out.print("价格：");

			double p = scanner.nextDouble();

			System.out.print("数量：");

			int b = scanner.nextInt();

			names[i] = n;

			prices[i] = p;

			numbers[i] = b;

		}

		// 重新显示商品列表

		f1();

	}

	private static void f3() {

		System.out.print("查询的商品名称：");

		String n = new Scanner(System.in).nextLine();

		// 遍历数组

		for (int i = 0; i < names.length; i++) {

			// i位置商品名与查询的商品名n是否相等

			// 字符串比较是否相等，要用equals()方法

			if (names[i].equals(n)) {

				System.out.println(

						(i + 1) + ". 名称：" + names[i] +

								"，价格：" + prices[i] +

								"，数量：" + numbers[i]);

				return;// 方法到此结束

			}

		}

		System.out.println("找不到商品");

	}

	private static void f4() {

		/*
		 * 
		 * 商品总价
		 * 
		 * 平均单价
		 * 
		 * 最高单价
		 * 
		 * 最高总价
		 * 
		 */

		double spzj = 0;// 商品总价

		double djzj = 0;// 单价总价

		double zgdj = 0;// 最高单价

		double zgzj = 0;// 最高总价

		// 遍历

		for (int i = 0; i < names.length; i++) {

			spzj += prices[i] * numbers[i];

			djzj += prices[i];

			if (prices[i] > zgdj) {

				zgdj = prices[i];

			}

			if (prices[i] * numbers[i] > zgzj) {

				zgzj = prices[i] * numbers[i];

			}

		}

		System.out.println("商品总价: " + spzj);

		System.out.println("平均单价: " + (djzj / names.length));

		System.out.println("最高单价: " + zgdj);

		System.out.println("最高总价: " + zgzj);

	}

}
