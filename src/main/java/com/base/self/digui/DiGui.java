package com.base.self.digui;

public class DiGui {
    public static void main(String[] args) {
        int a = fun(101);
        System.out.println(a);
        int sum = 0;
        for (int i = 101; i <= 200; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static int fun(int num) {
        int sum = 0;
        if (num <= 200) {
            sum = num + fun(num + 1);
        }
        return sum;
    }
}
