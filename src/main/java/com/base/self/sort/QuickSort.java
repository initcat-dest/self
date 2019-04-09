package com.base.self.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author libo
 * @package com.base.self.sort
 * @company xmiles
 * @date 2019/4/9
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        sort(a, 0, a.length - 1);
        Arrays.stream(a).mapToObj(i -> i + ", ").forEachOrdered(System.out::print);
    }

    private static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }

    private static int partition(int[] array, int lo, int hi) {
        // 固定的切分方式
        int key = array[lo];
        while (lo < hi) {
            //从后半部分向前扫描
            while (array[hi] >= key && hi > lo) {
                hi--;
            }
            array[lo] = array[hi];
            // 从前半部分向后扫描
            while (array[lo] <= key && hi > lo) {
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

}
