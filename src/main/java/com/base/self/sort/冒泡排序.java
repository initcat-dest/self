package com.base.self.sort;

public class 冒泡排序 {
	public static void maoPao(int array[]) {
		int i,j,temp;
		int len = array.length;
		for (i = 0; i < len - 1; i++) {
			for (j = 0; j < len -1; j++) {
				if (array[j] < array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int a[] = {36,25,48,12,25,65,43,57};
		maoPao(a);
		for(int i : a){
			System.out.print(i+",");
		}

	}
}
