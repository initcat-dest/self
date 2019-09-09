package com.base.self.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 插入排序
 * 时间复杂度：O(n^2)
 * 从第一个元素开始，该元素可以认为已经被排序
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 将新元素插入到该位置中
 * 重复步骤2
 *
 * @author dest
 */
public class InsertSort {

    private static void insertSort(int[] a) {
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
        insertSort(a);
        System.out.println(ArrayUtils.toString(a));
    }

}
