package com.base.self.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 希尔排序
 * 升级版的插入排序
 *
 * @author dest
 */
public class ShellSort {

    private static void shellSort(int[] array) {
        // 希尔排序的增量
        int d = array.length;
        while (d > 1) {
            // 使用希尔增量的方式，即每次折半
            d = d / 2;
            System.out.println("当前d:" + d);
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int j, temp = array[i];
                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {11, 3, 1, 2, 4, 6, 5, 9, 8};
        shellSort(a);
        System.out.println(ArrayUtils.toString(a));
    }

}
