package com.base.self.sort;

import java.io.File;
import java.util.Scanner;

/**
 * 冒泡排序
 * @author dest
 */
public class BubblingSort {
	public static void maoPao(int[] array) {
		int i, j, temp;
		int len = array.length;
		for (i = 0; i < len - 1; i++) {
			for (j = 0; j < len - 1; j++) {
				if (array[j] < array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			String read = scan.nextLine();
			arr[i] = Integer.valueOf(read);
		}
		maoPao(arr);

	}


	public void test(String strPath) {
		File f = new File(strPath);
		if (f.isDirectory()) {
			File[] fList = f.listFiles();
			for (int j = 0; j < fList.length; j++) {
				if (fList[j].isDirectory()) {
					System.out.println(fList[j].getPath());
					//在test函数里面又调用了getDir函数本身
					test(fList[j].getPath());
				}
			}
			for (int j = 0; j < fList.length; j++) {

				if (fList[j].isFile()) {
					System.out.println(fList[j].getPath());
				}
			}
		}
	}



}
