package com.base.self.sort;

public class 插入排序 {

    public static void chaRu(int a[]) {
        int i, j, temp;
        int len = a.length;
        for (i = 1; i < len; i++) {
            j = i;
            temp = a[i];
            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4, 6, 5};
        chaRu(a);
        for (int i : a) {
            System.out.print(i + ",");
        }
    }

}
