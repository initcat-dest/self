package com.base.self.sort;

import java.io.File;
import java.util.Scanner;

/**
 * 冒泡法排序
 * 比较相邻的元素。如果第一个比第二个小，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最小的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
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
