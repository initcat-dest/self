package com.base.self.sort;

/**
 * 选择排序
 * 在未排序序列中找到最小元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列起始位置。
 * 以此类推，直到所有元素均排序完毕。 *
 *
 * @author libo
 * @package com.base.self.sort
 * @company xmiles
 * @date 2019/4/9
 */
public class SelectSort {

    public static void selectSort(int[] numbers) {
        int size = numbers.length;
        int temp;
        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) {
                    k = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }
}
